import { inject, Service, signal, Signal } from '@angular/core';
import { Product } from '../../models/product';
import { Observable, from } from 'rxjs';
import { Order } from '../../models/order';
import { AuthenticationService } from '../authentication/authentication-service';

@Service()
export class ProductService {
    path: string = 'http://localhost:8080';
    cart: Array<Product> = [];
    cartInventory = signal(0);
    authenticationService:AuthenticationService;

    public constructor(){
        this.authenticationService = inject(AuthenticationService);
    }

    getProducts(): Observable<Array<Product>> {
        return from(
            fetch(`${this.path}/books/available`)
                .then(response => response.json())
                .then(data => data as Array<Product>)
        );
    }

    private getProduct(id: number): Observable<Product> {
        return from(
            fetch(`${this.path}/books/findById?id=${id}`)
                .then(response => response.json())
                .then(data => data as Product)
        );
    }

    getImageURL(id: number): String {
        return `${this.path}/books/${id}/image`;
    }

    addToCart(productId: number, quantity: number) {
        // This logic should be in the backend.
        const productAlreadyInCart = this.cart.find(product => product.id === productId);
        this.getProduct(productId).subscribe(product => {
            if(productAlreadyInCart){
                if(product.quantity >= productAlreadyInCart.quantity + quantity){
                    productAlreadyInCart.quantity += quantity;
                    this.updateInventory(quantity);
                    return;
                }
            } else if(product.quantity >= quantity){
                this.cart.push({...product, quantity});
                this.updateInventory(quantity);
                return;
            }
            throw new Error('Not enough items in stock.');
        });
    }

    removeFromCart(productId: number, quantity: number){
        const product = this.cart.find(product => product.id === productId);
        if(product === undefined) {
            throw new Error('This item is not in the cart yet.');
        }

        if(product.quantity >= quantity) {
            product.quantity = product.quantity - quantity;
            this.updateInventory(-quantity);
        }

        if(product.quantity === 0){
            this.cart = this.cart.filter(product => product.id !== productId);
        }
    }

    getCart(): Array<Product> {
        return this.cart;
    }

    getNbrInCart(productId: number): number {
        const product = this.cart.find(product => product.id === productId);
        return product ? product.quantity : 0;
    }

    private updateInventory(variation: number) {
        const updatedValue = this.cartInventory() + variation;
        this.cartInventory.set(updatedValue);
    }

    public orderBooksInCart():Observable<Order> {
        const user = this.authenticationService.userSignal();
        const order:Order = {
            userId: user.id,
            books: this.cart,
            timestamp: Date.now().toString()
        };

        return from(
            fetch(`${this.path}/order/books`, {
                    method: 'POST',
                    headers: {
                    'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(order)
                })
                .then(response => response.json())
                .then(data => data as Order)
        );
    }
}

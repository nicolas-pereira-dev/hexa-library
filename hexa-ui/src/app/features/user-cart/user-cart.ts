import { Component } from '@angular/core';
import { ProductService } from '../../services/product/product-service';
import { Product } from '../../models/product';
import { ProductList } from "../../components/product-list/product-list";
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-user-cart',
  imports: [ProductList, RouterLink],
  templateUrl: './user-cart.html',
  styleUrl: './user-cart.css',
})
export class UserCart {
  cart: Array<Product> = [];

  constructor(private productService: ProductService) {}

  ngOnInit() {
    this.cart = this.productService.getCart();
  }

  public orderBooksInCart(){
    this.productService.orderBooksInCart();
  }
}

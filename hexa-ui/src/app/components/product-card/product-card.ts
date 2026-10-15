import { Component, Input, OnInit } from '@angular/core';
import { Product } from '../../models/product';
import { ProductService } from '../../services/product/product-service';

@Component({
  selector: 'app-product-card',
  imports: [],
  templateUrl: './product-card.html',
  styleUrl: './product-card.css',
})
export class ProductCard implements OnInit {
  @Input() product!: Product;
  imageURL: String = '';

  constructor(private productService: ProductService) {}

  ngOnInit() {
    this.imageURL = this.productService.getImageURL(this.product.id);
  }

  addToCart(productId: number) {
    this.productService.addToCart(productId, 1);
  }

  removeFromCart(productId: number) {
    this.productService.removeFromCart(productId, 1);
  }

  getNbrInCart(productId: number) {
    this.productService.getNbrInCart(productId);
  }
}

import { Component } from '@angular/core';
import { ProductList } from "../../components/product-list/product-list";
import { ProductService } from '../../services/product/product-service';
import { Product } from '../../models/product';
import { Observable } from 'rxjs/internal/Observable';
import { AsyncPipe } from '@angular/common';
import { SearchBar } from "../../components/search-bar/search-bar";

@Component({
  selector: 'app-shop-page',
  imports: [ProductList, AsyncPipe, SearchBar],
  templateUrl: './shop-page.html',
  styleUrl: './shop-page.css',
})
export class ShopPage {
  products$!: Observable<Array<Product>>;

  constructor(private productService: ProductService) {}

  ngOnInit() {
    this.products$ = this.productService.getProducts();
  }

}

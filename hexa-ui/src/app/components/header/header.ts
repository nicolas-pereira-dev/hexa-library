import { Component, Signal } from '@angular/core';
import { TitleCasePipe } from '@angular/common';
import { RouterLink } from '@angular/router';
import { AuthenticationService } from '../../services/authentication/authentication-service';
import { User } from '../../models/user';
import { ProductService } from '../../services/product/product-service';

@Component({
  selector: 'app-header',
  imports: [RouterLink, TitleCasePipe],
  templateUrl: './header.html',
  styleUrl: './header.css',
})
export class Header {
  cartInventory: Signal<number>;
  isAuthenticated: Signal<boolean>;
  userSignal: Signal<User>;


  constructor(
    private authenticationService: AuthenticationService,
    private productService: ProductService
  ) {
    this.cartInventory = this.productService.cartInventory;
    this.isAuthenticated = this.authenticationService.isAuthenticated;
    this.userSignal = this.authenticationService.userSignal;
  }
}

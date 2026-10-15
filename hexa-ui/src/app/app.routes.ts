import { Routes } from '@angular/router';
import { ShopPage } from './features/shop-page/shop-page';
import { UserCart } from './features/user-cart/user-cart';
import { LoginPage } from './features/login-page/login-page';
import { ProfilePage } from './features/profile-page/profile-page';

export const routes: Routes = [
    {
        path: '', 
        component: ShopPage
    },
    {
        path: 'shop', 
        component: ShopPage
    },
    {
        path: 'cart',
        component: UserCart
    },
    {
        path: 'contact',
        component: ShopPage
    },
    {
        path: 'profile',
        component: ProfilePage
    },
    {
        path: 'login',
        component: LoginPage
    },
    {
        path: 'register',
        component: LoginPage
    }
];

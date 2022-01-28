import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { OrderListComponent } from './admin/order-list/order-list.component';
import { ProductDetailComponent } from './admin/product-detail/product-detail.component';
import { ProductListComponent } from './admin/product-list/product-list.component';
import { CartComponent } from './cart/cart.component';
import { HomeComponent } from './home/home.component';
import {AuthGuard} from "./common/auth/auth.guard";
import {LoginComponent} from "./login/login.component";

const routes: Routes = [
  {path: '', redirectTo: 'home', pathMatch: 'full' },
  {path: 'home', component:HomeComponent },
  {path: 'cart', component:CartComponent},
  {path: 'login', component:LoginComponent},
  {path: 'admin', component:ProductListComponent, canActivate:[AuthGuard]},
  {path: 'admin/product-list', component:ProductListComponent, canActivate:[AuthGuard]},
  {path: 'admin/product-detail', component:ProductDetailComponent, canActivate:[AuthGuard]},
  {path: 'admin/product-detail/:id', component:ProductDetailComponent, canActivate:[AuthGuard]},
  {path: 'admin/order-list', component:OrderListComponent, canActivate:[AuthGuard]},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

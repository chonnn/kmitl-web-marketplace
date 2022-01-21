import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { OrderListComponent } from './admin/order-list/order-list.component';
import { ProductDetailComponent } from './admin/product-detail/product-detail.component';
import { ProductListComponent } from './admin/product-list/product-list.component';
import { CartComponent } from './cart/cart.component';
import { HomeComponent } from './home/home.component';

const routes: Routes = [
  {path: '', redirectTo: 'home', pathMatch: 'full' },
  {path: 'home', component:HomeComponent },
  {path: 'cart', component:CartComponent},
  {path: 'admin', component:ProductListComponent},
  {path: 'admin/product-list', component:ProductListComponent},
  {path: 'admin/product-detail', component:ProductDetailComponent},
  {path: 'admin/product-detail/:id', component:ProductDetailComponent},
  {path: 'admin/order-list', component:OrderListComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ProductListComponent } from './admin/product-list/product-list.component';
import { ProductDetailComponent } from './admin/product-detail/product-detail.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { CollapseModule } from 'ngx-bootstrap/collapse';
import { HomeComponent } from './home/home.component';
import { CartComponent } from './cart/cart.component';
import { OrderListComponent } from './admin/order-list/order-list.component';
import { OrderDetailComponent } from './admin/order-detail/order-detail.component';
import { AdminMenuComponent } from './admin/admin-menu/admin-menu.component';
import { LoadingComponent } from './common/loading/loading.component';
import { NgxSpinnerModule } from 'ngx-spinner';
import {LoadingInterceptor} from "./common/loading/loading.interceptor";
import { SweetAlert2Module } from '@sweetalert2/ngx-sweetalert2';

@NgModule({
  declarations: [
    AppComponent,
    ProductListComponent,
    ProductDetailComponent,
    HomeComponent,
    CartComponent,
    OrderListComponent,
    OrderDetailComponent,
    AdminMenuComponent,
    LoadingComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    NgxSpinnerModule,
    HttpClientModule,
    FormsModule,
    CollapseModule.forRoot(),
    SweetAlert2Module.forRoot({
      provideSwal: () => import('sweetalert2/dist/sweetalert2.js')
    }),
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: LoadingInterceptor,
      multi: true
    },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

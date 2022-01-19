import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProductDetailComponent } from './admin/product-detail/product-detail.component';
import { ProductListComponent } from './admin/product-list/product-list.component';

const routes: Routes = [
  {path: '', redirectTo: 'heroes', pathMatch: 'full' },
  {path: 'admin', component:ProductListComponent},
  {path: 'admin/product-list', component:ProductListComponent},
  {path: 'admin/product-detail', component:ProductDetailComponent},
  {path: 'admin/product-detail/:id', component:ProductDetailComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

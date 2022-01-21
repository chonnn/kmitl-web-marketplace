import { Component, OnInit } from '@angular/core';
import { Product } from '../interface/product';
import { ProductService } from '../service/product.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  products!:Product[];

  cartKey:string = 'cart';

  constructor(private productService:ProductService) { }

  ngOnInit(): void {
    this.productService.getProducts().subscribe((res)=>{
      this.products = res;
    });
  }

  addToCart(product:Product){
    let cartProducts:Product[] = [];
    if(localStorage.getItem(this.cartKey)){
      cartProducts = JSON.parse(localStorage.getItem(this.cartKey)||'');
    }
    cartProducts.push(product);
    localStorage.setItem(this.cartKey,JSON.stringify(cartProducts));
    alert('Add to cart successfuly!')
  }

}

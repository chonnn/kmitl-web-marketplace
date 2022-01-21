import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { OrderDetail, Orders } from '../interface/orders';
import { Product } from '../interface/product';
import { OrderService } from '../service/order.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  orders:Orders = {
    id:"",
    name:"",
    orderDetails:[]
  };

  products!:Product[];
  sumPrice!:number;

  cartKey:string = 'cart';

  constructor(private router:Router,
      private orderService:OrderService
    ) { }

  ngOnInit(): void {
    this.products = JSON.parse(localStorage.getItem(this.cartKey)||'');
    this.sumPrice = 0;
    this.products.forEach(item => {
      this.sumPrice += item.price||0;
    })
  }

  placeOrder(){
    let orderDetailList:OrderDetail[] = [];
    let orderDetail:OrderDetail;
    this.products.forEach(item => {
      orderDetail = {
        productId:item.id,
        productName:item.name,
        price:item.price
      };
      orderDetailList.push(orderDetail);
    })

    this.orders.orderDetails = orderDetailList;

    this.orderService.saveOrder(this.orders).subscribe( (res)=>{
      alert("Your order have been placed! Thank you.");
      localStorage.setItem(this.cartKey,'');
          
      this.router.navigate(['/home']);
    });


  }

}

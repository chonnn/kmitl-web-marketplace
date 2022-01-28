import { Component, OnInit } from '@angular/core';
import { Orders } from 'src/app/interface/orders';
import { OrderService } from 'src/app/service/order.service';

@Component({
  selector: 'app-order-list',
  templateUrl: './order-list.component.html',
  styleUrls: ['./order-list.component.css']
})
export class OrderListComponent implements OnInit {

  orders!:Orders[];

  constructor(private orderService:OrderService) { }

  ngOnInit(): void {
    this.orderService.getAdminOrder().subscribe(res => {
      this.orders = res;
    });
  }

}

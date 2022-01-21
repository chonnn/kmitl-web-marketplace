import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Orders } from '../interface/orders';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private http: HttpClient) { }

  getProducts(): Observable<Orders[]> {
    return this.http.get<Orders[]>(environment.apiUrl + '/api/orders');
  }

  saveOrder(orders:Orders): Observable<Orders> {
    return this.http.post<Orders>(environment.apiUrl + '/api/order', orders);
  }
}

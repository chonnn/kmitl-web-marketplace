import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {Login, Token} from '../interface/auth';
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  constructor(private http: HttpClient) { }

  login(data:Login): Observable<Token> {
    return this.http.post<Token>(environment.apiUrl + '/api/auth/login' ,data);
  }
}

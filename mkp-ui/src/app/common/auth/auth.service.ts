import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private tokenName = 'token';

  constructor(private http: HttpClient,
              private router: Router) {
  }

  isLogin():boolean{
    if(localStorage.getItem(this.tokenName)){
      return true;
    }
    return false;
  }

  logout() {
    localStorage.removeItem(this.tokenName);
    this.router.navigate(['/login'])
  }

  forwardToLogin() {
    this.router.navigate(['/login'])
  }

  saveToken(token: string) {
    localStorage.setItem(this.tokenName, token);
  }

  getToken():string{
    return localStorage.getItem(this.tokenName)||"";
  }
}

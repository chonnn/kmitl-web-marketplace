import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor,
  HttpErrorResponse,
  HttpHeaders
} from '@angular/common/http';
import { Observable, tap } from 'rxjs';
import { AuthService } from './auth.service';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  constructor(private authService:AuthService) {
  }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    let token = this.authService.getToken();
    if(token === null){
      token = '';
    }
    const authReq = req.clone({
      headers: new HttpHeaders({
        'Authorization':  token,
      })
    });
    return next.handle(authReq).pipe(tap(event=>{

    },error=>{
      if (error instanceof HttpErrorResponse) {
        if(error.status === 401){
          this.authService.logout();
        }
      }
    }));
  }
}

import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import {finalize, Observable } from 'rxjs';
import {LoadingService} from "./loading.service";

@Injectable()
export class LoadingInterceptor implements HttpInterceptor {


  activeRequests: number = 0;

  constructor(private loadingService: LoadingService) {
  }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    console.log(req.url)
    if (this.activeRequests === 0) {
      this.loadingService.startLoading();
    }
    this.activeRequests++;
    return next.handle(req).pipe(
      finalize(() => {
        this.activeRequests--;
        if (this.activeRequests === 0) {
          this.loadingService.stopLoading();
        }
      })
    )
  }

}

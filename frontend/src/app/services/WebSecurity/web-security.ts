import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class WebSecurity implements HttpInterceptor{
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const auth = localStorage.getItem('auth');
    if (auth) {
      const cloned = req.clone({
        headers: req.headers.set('Authorization', `Basic ${auth}`)
      });
      return next.handle(cloned);
    }
    return next.handle(req);
  }
}

import {
  HttpErrorResponse,
  HttpEvent,
  HttpHandler,
  HttpInterceptor,
  HttpRequest,
  HttpResponse,
  HTTP_INTERCEPTORS,
} from '@angular/common/http';
import { Injectable, NgModule } from '@angular/core';
import { throwError, Observable } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';

@Injectable()

/*toda requisição essa classe sera chamada para colocar o token no backend*/
export class HeaderInterceptorService implements HttpInterceptor {
  /*metodo criado conformde segustão da IDE*/
  intercept(
    req: HttpRequest<any>,
    next: HttpHandler
  ): Observable<HttpEvent<any>> {
    /*se token é diferente de null então criar */
    if (localStorage.getItem('token') !== null) {
      const token = 'Bearer ' + localStorage.getItem('token');
      /*sobrescrevendo a parte da requisição e vai passar a requisição pelo cabeçalho*/
      const tokenRequest = req.clone({
        headers: req.headers.set('Authorization', token)
      });
      /*continuar "next" e passar a requisição com o tokenRequest*/
      return next.handle(tokenRequest).pipe(
        tap((event: HttpEvent<any>) => {
          if (
            event instanceof HttpResponse &&
            (event.status === 200 || event.status === 201)
          ) {
            console.info('Sucesso na Operação');
          }
        }),
        catchError(this.processaError)
      );
    } else {
      /*senão tem token passa requisição original */
      return next.handle(req).pipe(catchError(this.processaError));
    }
  }
  constructor() {}

  processaError(error: HttpErrorResponse) {
    let errorMessage = 'Erro desconhecido';
    if (error.error instanceof ErrorEvent) {
      console.error(error.error);
      errorMessage = 'Error: ' + error.error.error;
    } else {
      errorMessage =
        'Código: ' + error.error.code + '\nMensagem: ' + error.error.error;
    }
    window.alert(errorMessage);
    return throwError(errorMessage);
  }
}

/*transfomando em um modulo essa requisição */
@NgModule({
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: HeaderInterceptorService,
      multi: true,
    },
  ],
})
/*exportando essa classe em um modulo*/
export class HttpInterceptorModule {}

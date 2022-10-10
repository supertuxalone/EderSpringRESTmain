"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
exports.__esModule = true;
exports.HttpInterceptorModule = exports.HeaderInterceptorService = void 0;
var http_1 = require("@angular/common/http");
var core_1 = require("@angular/core");
var rxjs_1 = require("rxjs");
var operators_1 = require("rxjs/operators");
var HeaderInterceptorService = /** @class */ (function () {
    function HeaderInterceptorService() {
    }
    /*metodo criado conformde segustão da IDE*/
    HeaderInterceptorService.prototype.intercept = function (req, next) {
        /*se token é diferente de null então criar */
        if (localStorage.getItem('token') !== null) {
            var token = 'Bearer ' + localStorage.getItem('token');
            /*sobrescrevendo a parte da requisição e vai passar a requisição pelo cabeçalho*/
            var tokenRequest = req.clone({
                headers: req.headers.set('Authorization', token)
            });
            /*continuar "next" e passar a requisição com o tokenRequest*/
            return next.handle(tokenRequest).pipe(operators_1.tap(function (event) {
                if (event instanceof http_1.HttpResponse &&
                    (event.status === 200 || event.status === 201)) {
                    console.info('Sucesso na Operação');
                }
            }), operators_1.catchError(this.processaError));
        }
        else {
            /*senão tem token passa requisição original */
            return next.handle(req).pipe(operators_1.catchError(this.processaError));
        }
    };
    HeaderInterceptorService.prototype.processaError = function (error) {
        var errorMessage = 'Erro desconhecido';
        if (error.error instanceof ErrorEvent) {
            console.error(error.error);
            errorMessage = 'Error: ' + error.error.error;
        }
        else {
            errorMessage =
                'Código: ' + error.error.code + '\nMensagem: ' + error.error.error;
        }
        window.alert(errorMessage);
        return rxjs_1.throwError(errorMessage);
    };
    HeaderInterceptorService = __decorate([
        core_1.Injectable()
        /*toda requisição essa classe sera chamada para colocar o token no backend*/
    ], HeaderInterceptorService);
    return HeaderInterceptorService;
}());
exports.HeaderInterceptorService = HeaderInterceptorService;
/*transfomando em um modulo essa requisição */
var HttpInterceptorModule = /** @class */ (function () {
    /*exportando essa classe em um modulo*/
    function HttpInterceptorModule() {
    }
    HttpInterceptorModule = __decorate([
        core_1.NgModule({
            providers: [
                {
                    provide: http_1.HTTP_INTERCEPTORS,
                    useClass: HeaderInterceptorService,
                    multi: true
                },
            ]
        })
        /*exportando essa classe em um modulo*/
    ], HttpInterceptorModule);
    return HttpInterceptorModule;
}());
exports.HttpInterceptorModule = HttpInterceptorModule;

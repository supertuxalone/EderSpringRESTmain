"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
exports.__esModule = true;
exports.AppModule = exports.routes = exports.appRouters = void 0;
var core_1 = require("@angular/core");
var platform_browser_1 = require("@angular/platform-browser");
var forms_1 = require("@angular/forms");
var app_component_1 = require("./app.component");
var http_1 = require("@angular/common/http");
var home_component_1 = require("./home/home.component"); /*Resquisições em Ajax*/
var router_1 = require("@angular/router");
var login_component_1 = require("./login/login.component");
var headr_module_1 = require("./components/headr/headr.module");
var header_interceptor_service_1 = require("./service/header-interceptor.service");
exports.appRouters = [
    {
        /*quando passar a url  http://localhost:4200/home ele vai chamar o componet HomeComponent*/
        path: 'home', component: home_component_1.HomeComponent
    },
    {
        /*quando passar a url  http://localhost:4200/login ele vai chamar o componet LoginComponent*/
        path: 'login', component: login_component_1.LoginComponent
    },
    {
        /*quando passar a url  http://localhost:4200/ "raiz" ele vai chamar o componet LoginComponent*/
        path: '', component: login_component_1.LoginComponent
    }
];
/*exportando o modulo ModuleWithProviders<type-argument> para que ele possa ler o array de rotas acima */
exports.routes = router_1.RouterModule.forRoot(exports.appRouters);
var AppModule = /** @class */ (function () {
    function AppModule() {
    }
    AppModule = __decorate([
        core_1.NgModule({
            declarations: [
                app_component_1.AppComponent,
                home_component_1.HomeComponent,
                login_component_1.LoginComponent,
            ],
            imports: [
                platform_browser_1.BrowserModule,
                forms_1.FormsModule,
                http_1.HttpClientModule,
                headr_module_1.HeadrModule,
                exports.routes,
                header_interceptor_service_1.HttpInterceptorModule,
            ],
            providers: [],
            bootstrap: [app_component_1.AppComponent]
        })
    ], AppModule);
    return AppModule;
}());
exports.AppModule = AppModule;

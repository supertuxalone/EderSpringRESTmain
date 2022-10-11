import { ModuleWithProviders, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { HomeComponent } from './home/home.component'; /*Resquisições em Ajax*/
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { UserComponentComponent } from './components/userComponent/userComponent.component';


export const appRouters: Routes = [
  {
    /*quando passar a url  http://localhost:4200/home ele vai chamar o componet HomeComponent*/
    path: 'home',
    component: HomeComponent,
  },
  {
    /*quando passar a url  http://localhost:4200/login ele vai chamar o componet LoginComponent*/
    path: 'login',
    component: LoginComponent,
  },
  {
    /*quando passar a url  http://localhost:4200/ "raiz" ele vai chamar o componet LoginComponent*/
    path: '',
    component: LoginComponent,
  },
  {
    /*quando passar a url  http://localhost:4200/ "raiz" ele vai chamar o componet LoginComponent*/
    path: 'userlist',
    component: UserComponentComponent,
  },
];
/*exportando o modulo ModuleWithProviders<type-argument> para que ele possa ler o array de rotas acima */
export const routes: ModuleWithProviders = RouterModule.forRoot(appRouters);

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    UserComponentComponent,
  ],
  imports: [BrowserModule, FormsModule, HttpClientModule, routes],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}

/*https://splunktool.com/jwt-library-error-generic-type-modulewithproviderst-requires-1-type-arguments-in-angular-10*/
declare module '@angular/core' {
  interface ModuleWithProviders<T = any> {
    ngModule: Type<T>;
    providers?: Provider[];
  }
}

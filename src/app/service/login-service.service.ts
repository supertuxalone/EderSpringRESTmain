import { routes } from './../app.module';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { AppConstants } from '../app-constants';

@Injectable({
  providedIn: 'root',
})
export class LoginServiceService {
  constructor(private http: HttpClient, private router : Router) {}

  /*metodo vai recebendo os valores coletados e atribuidos a user*/
  login(user: any) {
    console.info('Login Service : ' + user.login);
    return this.http
      .post(AppConstants.baseLogin, JSON.stringify(user))
      .subscribe(
        (data) => {
          /*Retorno hhtp */
          /*validando rertorno, pega somente a string do token removendo o ' ' e o Bearer */
          var token = JSON.parse(JSON.stringify(data)).Authorization.split(' ')[1];
            /*armazenar atras do frontend o valor recebido do servidor */
          localStorage.setItem("token", token);
          console.log("Token Gerado")
          /*só para exibir no console do navegador */
          //console.info("Token : " + localStorage.getItem("token"));
          /*navegação para onde vai depois de autenticar */
          this.router.navigate(['home']);

        },
        /*tratar caso tiver alguma error ao tentar logar*/
        (error) => {
          console.log('Login Incorreto');
        }
      );
  }
}

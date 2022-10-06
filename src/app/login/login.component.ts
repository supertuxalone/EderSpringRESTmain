import { Component, OnInit } from '@angular/core';
import { LoginServiceService } from 'src/app/service/login-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  /*ao instaciar essa classe*/
  user =  {login : '', senha : ''}

  /*criar constructor */
  constructor (private loginServiceService : LoginServiceService){}

  /*função que o botão acessar da tela de login */
  public login(){
    this.loginServiceService.login(this.user);
    // console.log("Test Login " + this.user.login + "senha :" + this.user.senha)
  }

  ngOnInit(): void {

  }

}

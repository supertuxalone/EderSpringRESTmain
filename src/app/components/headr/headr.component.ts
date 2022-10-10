import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-headr',
  templateUrl: './headr.component.html',
  styleUrls: ['./headr.component.css']
})
export class HeadrComponent implements OnInit {

  constructor(private router : Router) { }

  ngOnInit(): void {
  }

  //interessante ele voltar para tela de login
  logout() {
      this.router.navigate(['']);
    }

    sair() {
      this.router.navigate(['']);
    }

}

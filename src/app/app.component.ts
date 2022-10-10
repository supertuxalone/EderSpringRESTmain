import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'EderSpringRESTMAIN';
  /*se ao iniciar o sistema não tiver token vai para o login */

  constructor(private router: Router) {
  }

  ngOnInit(): void {
    if (localStorage.getItem('token') == null) {
      this.router.navigate(['login']);
    }
    }
    /*clicar em sair limpa token e  volta para login */
    public sair(){
    localStorage.clear();
    this.router.navigate(['login']);

    }
}

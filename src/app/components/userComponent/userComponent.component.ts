import { UserServiceService } from './../../service/user-service.service';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from 'src/app/model/user';

@Component({
  selector: 'app-userComponent',
  templateUrl: './userComponent.component.html',
  styleUrls: ['./userComponent.component.css'],
})
export class UserComponentComponent implements OnInit {
  students: Observable<User[]> | any;

  /*declaração de userservice */
  constructor(private userServiceService: UserServiceService) {}

  ngOnInit() {
    /*carregando os usuarios e joga o resultado na variavel students */
    this.userServiceService.getStudentList().subscribe((data) => {
      this.students = data;
    });
  }
}

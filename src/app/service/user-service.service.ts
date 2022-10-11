import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppConstants } from '../app-constants';

@Injectable({
  providedIn: 'root',
})
export class UserServiceService {
  constructor(private http: HttpClient) {}

  /*faz uma requisição Ajax no Back-End Carregando os usuarios */
  getStudentList(): Observable<any> {
    return this.http.get<any>(AppConstants.baseUrl);
  }
}

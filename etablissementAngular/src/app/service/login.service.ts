import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Login } from '../model/login';
import { Utilisateur } from '../model/utilisateur';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) {}

  public auth(login: Login): Observable<Utilisateur> {
    const headers: HttpHeaders = new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'Basic ' + btoa(`${login.login}:${login.password}`),
    });
    return this.http.get<Utilisateur>('http://localhost:8080/etablissement/api/login', {
      headers: headers,
    });
  }
}

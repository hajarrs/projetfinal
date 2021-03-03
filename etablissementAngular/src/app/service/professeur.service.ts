import { HttpClient, HttpHeaders } from '@angular/common/http';
import { stringify } from '@angular/compiler/src/util';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Professeur } from '../model/professeur';

@Injectable({
  providedIn: 'root'
})
export class ProfesseurService {

  private url: string = 'http://localhost:8080/etablissement/api/professeur';

  private httpHeaders: HttpHeaders;

   constructor(private http: HttpClient) { 
    this.httpHeaders = new HttpHeaders({
      'content-type': 'application/json',
      Authorization: 'Basic ' + btoa('${login.login}:${login.password}'),
    });
  }

    public allProfesseur(): Observable<Professeur[]> {
      return this.http.get<Professeur[]>(this.url, { headers: this.httpHeaders });
    }
  
    public delete(id: number): Observable<void> {
      return this.http.delete<void>(this.url + '/' + id, {
        headers: this.httpHeaders,
      });
    }
  
    public update(professeur: Professeur): Observable<Professeur> {
      return this.http.put<Professeur>(`${this.url}/${professeur.id}`, professeur, {
        headers: this.httpHeaders,
      });
    }
  
    public insert(professeur: Professeur): Observable<Professeur> {
      const o = {
        //id: professeur.id,  
        login: professeur.login, 
        nom: professeur.nom,
        prenom: professeur.prenom,
        adresse: professeur.adresse,
        dateNaissance: professeur.dateNaissance,
        etablissement: professeur.etablissement,

        
      };
      return this.http.post<Professeur>(this.url+'/add', o, { headers: this.httpHeaders });
    }
}

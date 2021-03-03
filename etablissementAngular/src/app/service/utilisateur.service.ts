import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Utilisateur } from '../model/utilisateur';

@Injectable({
  providedIn: 'root'
})
export class UtilisateurService {

  private url: string = 'http://localhost:8080/etablissement/api/utilisateur';


   constructor(private http: HttpClient) { 
  }

  private get httpHeaders():HttpHeaders {
    return new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'Basic ' + localStorage.getItem('tokenId')
    });
  }

  public allUtilisateur(): Observable<Utilisateur[]> {
    return this.http.get<Utilisateur[]>(this.url, { headers: this.httpHeaders });
  }

  public delete(id: number): Observable<void> {
    return this.http.delete<void>(this.url + '/' + id, {
      headers: this.httpHeaders,
    });
  }

  public update(utilisateur: Utilisateur): Observable<Utilisateur> {
    return this.http.put<Utilisateur>(`${this.url}/${utilisateur.id}`, utilisateur, {
      headers: this.httpHeaders,
    });
  }

  public insert(utilisateur: Utilisateur): Observable<Utilisateur> {
    const o = {
      //id: utilisateur.id,  
      login: utilisateur.login, 
      nom: utilisateur.nom,
      prenom: utilisateur.prenom,
      adresse: utilisateur.adresse,
      dateNaissance: utilisateur.dateNaissance,
      etablissement: utilisateur.etablissement,

      
    };
    return this.http.post<Utilisateur>(this.url, o, { headers: this.httpHeaders });
  }

  public findById(id: number): Observable<Utilisateur> {
    return this.http.get<Utilisateur>(`${this.url}/${id}`,{ headers: this.httpHeaders });
  }

  public findByLogin(login: String): Observable<Utilisateur> {
    return this.http.get<Utilisateur>(`${this.url}/login/${login}`,{ headers: this.httpHeaders });
  }
}

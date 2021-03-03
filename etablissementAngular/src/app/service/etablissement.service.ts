import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Etablissement } from '../model/etablissement';

@Injectable({
  providedIn: 'root'
})
export class EtablissementService {
  private url: string = 'http://localhost:8080/etablissement';
  private httpHeaders: HttpHeaders;

  constructor(private http: HttpClient) { 
    this.httpHeaders = new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'Basic ' + localStorage.getItem('tokenId'),
    });
  }

  public allEtablissement(): Observable<Etablissement[]> {
    return this.http.get<Etablissement[]>(this.url, { headers: this.httpHeaders });
  }

  public delete(id: number): Observable<void> {
    return this.http.delete<void>(this.url + '/' + id, {
      headers: this.httpHeaders,
    });
  }

  public update(etablissement: Etablissement): Observable<Etablissement> {
    return this.http.put<Etablissement>(`${this.url}/${etablissement.id}`, etablissement, {
      headers: this.httpHeaders,
    });
  }

  public insert(etablissement: Etablissement): Observable<Etablissement> {
    const o = {
      nom: etablissement.nom,
      adresse: etablissement.adresse,
      numTel: etablissement.numTel,
      image: etablissement.image,
    };
    return this.http.post<Etablissement>(this.url, o, { headers: this.httpHeaders });
  }
  
}

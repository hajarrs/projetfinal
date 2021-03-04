import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Matiere } from '../model/matiere';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MatiereService {

  private url: string = 'http://localhost:8080/etablissement/api/matiere';

  private httpHeaders: HttpHeaders;



  constructor(private http: HttpClient) {
    this.httpHeaders = new HttpHeaders({
      'content-type': 'application/json',
      Authorization: 'Basic ' + sessionStorage.getItem('tokenId'),
    });
  

  }
  public allMatiere(): Observable<Matiere[]> {
    return this.http.get<Matiere[]>(this.url, { headers: this.httpHeaders });
  }

  public delete(id: number): Observable<void> {
    return this.http.delete<void>(this.url + '/' + id, {
      headers: this.httpHeaders,
    });
  }

  public update(matiere: Matiere): Observable<Matiere> {
    return this.http.put<Matiere>(`${this.url}/${matiere.id}`, matiere, {
      headers: this.httpHeaders,
    });
  }

  public insert(matiere: Matiere): Observable<Matiere> {
    const o = {
      nom: matiere.nom,
      couleur: matiere.couleur,
      
    };
    return this.http.post<Matiere>(this.url, o, { headers: this.httpHeaders });
  }

  public findById(id: number): Observable<Matiere> {
    return this.http.get<Matiere>(`${this.url}/${id}`,{ headers: this.httpHeaders });
  }

}

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { SalleClasse } from '../model/salle-classe';

@Injectable({
  providedIn: 'root'
})
export class SalleClasseService {

  private url: string = 'http://localhost:8080/etablissement/api/salleClasse';

  private httpHeaders: HttpHeaders;

  constructor(private http: HttpClient) {
    this.httpHeaders = new HttpHeaders({
      'content-type': 'application/json',
      Authorization: 'Basic ' + sessionStorage.getItem('tokenId'),
    });
  }

    public allSalleClasse(): Observable<SalleClasse[]> {
      return this.http.get<SalleClasse[]>(this.url, { headers: this.httpHeaders });
    }
  
    public delete(id: number): Observable<void> {
      return this.http.delete<void>(this.url + '/' + id, {
        headers: this.httpHeaders,
      });
    }
  
    public update(salleClasse: SalleClasse): Observable<SalleClasse> {
      return this.http.put<SalleClasse>(`${this.url}/${salleClasse.id}`, salleClasse, {
        headers: this.httpHeaders,
      });
    }
  
    public insert(salleClasse: SalleClasse): Observable<SalleClasse> {
      const o = {
        //id: salleClasse.id,   
        nom: salleClasse.nom,
        matieresExclues: salleClasse.matieresExclues,
        capacite: salleClasse.capacite
      };
      return this.http.post<SalleClasse>(this.url, o, { headers: this.httpHeaders });
    }

    public findById(id: number): Observable<SalleClasse> {
      return this.http.get<SalleClasse>(`${this.url}/${id}`,{ headers: this.httpHeaders });
    }


}

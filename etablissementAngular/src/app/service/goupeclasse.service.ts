import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { GroupeClasse } from '../model/groupe-classe';

@Injectable({
  providedIn: 'root'
})
export class GoupeclasseService {
  private url: string = 'http://localhost:8080/etablissement/api/groupeClasse';
  private httpHeaders: HttpHeaders;
  
  constructor(private http: HttpClient) { 
    this.httpHeaders = new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'Basic ' + sessionStorage.getItem('tokenId'),
    });
  }

  public allGroupeclasse(): Observable<GroupeClasse[]> {
    return this.http.get<GroupeClasse[]>(this.url, { headers: this.httpHeaders });
  }

  public delete(id: number): Observable<void> {
    return this.http.delete<void>(this.url + '/' + id, {
      headers: this.httpHeaders,
    });
  }

  public update(groupeclasse: GroupeClasse): Observable<GroupeClasse> {
    return this.http.put<GroupeClasse>(`${this.url}/${groupeclasse.id}`, groupeclasse, {
      headers: this.httpHeaders,
    });
  }

  public insert(groupeclasse: GroupeClasse): Observable<GroupeClasse> {
    const o = {
      nom: groupeclasse.nom,
      //professeurPrincipal: groupeclasse.,
      //
     
    };
    return this.http.post<GroupeClasse>(this.url, o, { headers: this.httpHeaders });
  }
  
}

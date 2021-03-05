import { HttpClient, HttpHeaders} from'@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cours } from '../model/cours';

@Injectable({
  providedIn: 'root'
})
export class CoursService {

  private url: string = 'http://localhost:8080/etablissement/api/cours';

  private httpHeaders: HttpHeaders;

  constructor(private http: HttpClient) {

    this.httpHeaders = new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'Basic ' + sessionStorage.getItem('tokenId'),
    });
  }

  public allCours(): Observable<Cours[]> {
    return this.http.get<Cours[]>(this.url, { headers: this.httpHeaders });
  }

  public allCoursForProfesseur(id: number): Observable<Cours[]> {
    return this.http.get<Cours[]>(this.url+'/professeur/' + id, { headers: this.httpHeaders });
  }

  public allCoursForSalle(id: number): Observable<Cours[]> {
    return this.http.get<Cours[]>(this.url+'/salle/' + id, { headers: this.httpHeaders });
  }

  public delete(id: number): Observable<void> {
    return this.http.delete<void>(this.url + '/' + id, {
      headers: this.httpHeaders,
    });
  }

  public update(cours: Cours): Observable<Cours> {
    return this.http.put<Cours>(`${this.url}/${cours.id}`, cours, {
      headers: this.httpHeaders,
    });
  }

  public insert(cours: Cours): Observable<Cours> {
    const o = {
      heureDebut: cours.heureDebut,
      heureFin: cours.heureFin,
      professeur: cours.professeur,
      matiere: cours.matiere,
      salle: cours.salle,
    };
    return this.http.post<Cours>(this.url, o, { headers: this.httpHeaders });
  }
}

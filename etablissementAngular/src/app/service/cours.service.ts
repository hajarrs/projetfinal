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
    const cours1 = {
      id : cours.id,
      day : cours.day,
      heureDebut: cours.heureDebut,
      heureFin: cours.heureFin,
      professeur: {id: cours.professeur.id},
      matiere:{id: cours.matiere.id},
      salle:{id: cours.salle.id}
    }
    console.log(cours1);
    console.log(cours);
    return this.http.put<Cours>(`${this.url}/${cours1.id}`, cours1, {
      headers: this.httpHeaders,
    });
  }

  public insert(cours: Cours): Observable<Cours> {
    const o = {
      day : cours.day,
      heureDebut: cours.heureDebut,
      heureFin: cours.heureFin,
      professeur: cours.professeur,
      matiere: cours.matiere,
      salle: cours.salle,
    };
    return this.http.post<Cours>(this.url, o, { headers: this.httpHeaders });
  }

  public findById(id: number): Observable<Cours> {
    return this.http.get<Cours>(`${this.url}/${id}`,{ headers: this.httpHeaders });
  }
}

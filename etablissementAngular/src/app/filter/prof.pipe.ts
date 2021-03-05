import { Professeur } from './../model/professeur';
import { Cours } from './../model/cours';
import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'profPipe'
})
export class ProfPipe implements PipeTransform {

  transform(listeCours: Cours[], profID: number): Cours[] {
    return listeCours.filter(cours => profID == 0 || cours.professeur.id == profID);
  }

}

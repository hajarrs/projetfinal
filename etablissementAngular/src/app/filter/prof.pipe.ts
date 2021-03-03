import { Professeur } from './../model/professeur';
import { Cours } from './../model/cours';
import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'prof'
})
export class ProfPipe implements PipeTransform {

  transform(listeCours: Cours[], prof: Professeur): Cours[] {
    return listeCours.filter(cours => cours.professeur == prof);
  }

}

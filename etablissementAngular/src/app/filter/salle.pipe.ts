import { Cours } from './../model/cours';
import { Pipe, PipeTransform } from '@angular/core';
import { SalleClasse } from '../model/salle-classe';

@Pipe({
  name: 'salle'
})
export class SallePipe implements PipeTransform {

  transform(listeCours: Cours[], salle: SalleClasse): Cours[] {
    return listeCours.filter(cours => cours.salle == salle);
  }

}

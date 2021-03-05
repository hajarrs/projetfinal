import { Cours } from './../model/cours';
import { Pipe, PipeTransform } from '@angular/core';
import { SalleClasse } from '../model/salle-classe';

@Pipe({
  name: 'sallePipe'
})
export class SallePipe implements PipeTransform {

  transform(listeCours: Cours[], salleID: number): Cours[] {
    return listeCours.filter(cours => salleID == 0 || cours.salle.id == salleID);
  }

}

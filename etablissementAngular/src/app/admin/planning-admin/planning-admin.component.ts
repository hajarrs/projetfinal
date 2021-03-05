import { SallePipe } from './../../filter/salle.pipe';
import { ProfPipe } from './../../filter/prof.pipe';
import { SalleClasseService } from './../../service/salle-classe.service';
import { ProfesseurService } from './../../service/professeur.service';
import { SalleClasse } from 'src/app/model/salle-classe';
import { Professeur } from './../../model/professeur';
import { CoursService } from './../../service/cours.service';
import { Cours } from './../../model/cours';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'planning-admin',
  templateUrl: './planning-admin.component.html',
  styleUrls: ['./planning-admin.component.scss']
})
export class PlanningAdminComponent implements OnInit {

  constructor(private coursService: CoursService, private profService: ProfesseurService, private salleService: SalleClasseService) { }

  ngOnInit() {
    this.coursService.allCours().subscribe((data) => {
      this.listeCours = data;
    });
    this.profService.allProfesseur().subscribe((data) => {
      this.listeProfs = data;
    });
    this.salleService.allSalleClasse().subscribe((data) => {
      this.listeSalles = data;
    });

  }

  listeCours: Cours[] = [];
  listeProfs: Professeur[] = [];
  listeSalles: SalleClasse[] = [];


  profID: number = 0;
  salleID: number = 0;

}




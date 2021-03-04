import { Cours } from './../../model/cours';
import { CoursService } from './../../service/cours.service';
import { Component, OnInit, Output } from '@angular/core';

@Component({
  selector: 'planning-prof',
  templateUrl: './planning-prof.component.html',
  styleUrls: ['./planning-prof.component.css']
})
export class PlanningProfComponent implements OnInit {

  constructor(private coursService: CoursService) { }

  ngOnInit(): void {
    this.coursService.allCoursForProfesseur(Number(sessionStorage.getItem("identifiant"))).subscribe((data) => {
      this.listeCours = data;
    });
  }

  listeCours: Cours[] = [];

}

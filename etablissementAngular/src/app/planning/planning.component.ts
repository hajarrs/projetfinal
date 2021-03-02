import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Cours } from '../model/cours';
import { CoursService } from '../service/cours.service';

@Component({
  selector: 'app-planning',
  templateUrl: './planning.component.html',
  styleUrls: ['./planning.component.css']
})
export class PlanningComponent implements OnInit {

  cours: Cours[] = [];

 //pb avec ce constructeur, pas d'affichage du component
 constructor(private coursService: CoursService) {}

  nom: string = '';
/*
  constructor(private coursService: CoursService, private activateRoute: ActivatedRoute) {
    this.activateRoute.params.subscribe(
      //traitements des parametres
      (params) => {
        this.cours = params.cours;
        console.log(this.cours);
      }
    );
  }*/

  ngOnInit(): void {
   this.init();
  }

 /* public init() {
    this.coursService.allCours().subscribe((data) => {

      this.cours = data;
      console.log(this.cours);
    });
  }*/

  public init() {
    this.coursService.allCours().subscribe((data) => {
      this.cours = data;
      console.log(this.cours);
    });
  }


}

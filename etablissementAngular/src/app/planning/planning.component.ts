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

  cours: Cours[] =[];
  ligne: Cours[] = new Array<Cours>(5);
  matrix: Cours[][] =[];

 //pb avec ce constructeur, pas d'affichage du component
 constructor(private coursService: CoursService) {
   for( let i =0; i<11; i++){
      this.matrix.push(new Array<Cours>(5));
   }
 }

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
      for(let k = 0 ; k<this.cours.length; k++){
        for( let i =0; i<11; i++){
          for( let j =0; j<5; j++){
            //console.log(this.cours[k].heureDebut.localeCompare("08:00:00"));
            if(this.cours[k].day===j){
              console.log(i+" "+j);
              this.matrix[i][j]=this.cours[k];
            }
        }}
      }
      for( let i =0; i<11; i++){
        for( let j =0; j<5; j++){
           console.log(this.matrix[i][j]);

      }}
      console.log(this.cours);
    });
  }


}

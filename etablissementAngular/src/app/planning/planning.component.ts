import { Component, ElementRef, Input, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Cours } from '../model/cours';
import { Matiere } from '../model/matiere';
import { Professeur } from '../model/professeur';
import { CoursService } from '../service/cours.service';
import jsPDF from 'jspdf';
import html2canvas from 'html2canvas';
import { SalleClasse } from '../model/salle-classe';


@Component({
  selector: 'app-planning',
  templateUrl: './planning.component.html',
  styleUrls: ['./planning.component.css']
})
export class PlanningComponent implements OnInit {

  cours: Cours[] =[];
  coursVide : Cours = new Cours();
  matrix: Cours[][] =[];
  heureD: number =0;
  heureF: number =0;
 //pb avec ce constructeur, pas d'affichage du component
 constructor(private coursService: CoursService) {
   for( let i =0; i<11; i++){
      this.matrix.push(new Array<Cours>(5));
   }
   for( let i =0; i<11; i++){
    for( let j =0; j<5; j++){
       this.matrix[i][j]= this.coursVide;
    }
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
    this.coursVide.matiere = new Matiere();
    this.coursVide.matiere.couleur="white";
    this.coursVide.professeur = new Professeur();
    this.coursVide.salle = new SalleClasse();
    this.coursService.allCours().subscribe((data) => {
      this.cours = data;
      for(let k = 0 ; k<this.cours.length; k++){
        for( let i =0; i<11; i++){
          for( let j =0; j<5; j++){

            //console.log(this.cours[k].heureDebut.localeCompare("08:00:00"));
            this.heureD= Number(this.cours[k].heureDebut.substring(0,2));
            this.heureF= Number(this.cours[k].heureFin.substring(0,2));

            if( this.heureD-8 ===i && this.cours[k].day===j){
              for(let h = i; h<i+(this.heureF-this.heureD); h++)
                {
                  this.matrix[h][j]=this.cours[k];
                }
                i=i+this.heureF-this.heureD;
            }
        }}
      }
    });
  }


  public openPDF():void {
    let DATA = document.getElementById('pdfTable');
    console.log(DATA);
    if (DATA) {
      html2canvas(DATA, {scrollY: -window.scrollY}).then(canvas => {
        const FILEURI = canvas.toDataURL('image/png')
        let PDF = new jsPDF('l', 'mm', 'a4');

        const imgProps= PDF.getImageProperties(FILEURI);
        const pdfWidth = PDF.internal.pageSize.getWidth();
        const pdfHeight = (imgProps.height * pdfWidth) / imgProps.width;
        PDF.addImage(FILEURI, 'PNG', 0, 0, pdfWidth, pdfHeight);

        PDF.save('Planning.pdf'); // ajouter éventuellement date dans le nom, prof, salle, etc
    });
    }
  }

}

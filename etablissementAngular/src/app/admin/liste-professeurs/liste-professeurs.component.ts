import { Component, OnInit } from '@angular/core';
import { Professeur } from 'src/app/model/professeur';
import { ProfesseurService } from 'src/app/service/professeur.service';

@Component({
  selector: 'app-liste-professeurs',
  templateUrl: './liste-professeurs.component.html',
  styleUrls: ['./liste-professeurs.component.css']
})
export class ListeProfesseursComponent implements OnInit {

  professeurs: Professeur[] = [];
  showNew: boolean = false;

  constructor(private utilisateurService: ProfesseurService) { }

  ngOnInit(): void {
    this.initList();
  }

  public initList() {
    this.utilisateurService.allProfesseur().subscribe((data) => {
      this.professeurs = data;
      console.log(data);
    });
  }

  public delete(id: number) {
    this.utilisateurService.delete(id).subscribe((result) => {
      this.initList();
    });
  }

  public displayNew() {
    this.showNew = !this.showNew;
  }

  public insert() {
    this.displayNew();
    this.initList();
  }

  public cancel() {
    this.displayNew();
  }

}
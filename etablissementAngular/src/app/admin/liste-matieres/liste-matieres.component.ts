import { Component, OnInit } from '@angular/core';
import { Matiere } from 'src/app/model/matiere';
import { MatiereService } from 'src/app/service/matiere.service';

@Component({
  selector: 'app-liste-matieres',
  templateUrl: './liste-matieres.component.html',
  styleUrls: ['./liste-matieres.component.css']
})
export class ListeMatieresComponent implements OnInit {

  matieres: Matiere[] = [];
  showNew: boolean = false;

  constructor(private utilisateurService: MatiereService) { }

  ngOnInit(): void {
    this.initList();
  }

  public initList() {
    this.utilisateurService.allMatiere().subscribe((data) => {
      this.matieres = data;
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

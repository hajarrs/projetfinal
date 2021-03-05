import { Component, OnInit } from '@angular/core';
import { SalleClasse } from 'src/app/model/salle-classe';
import { SalleClasseService } from 'src/app/service/salle-classe.service';

@Component({
  selector: 'app-liste-salles',
  templateUrl: './liste-salles.component.html',
  styleUrls: ['./liste-salles.component.css']
})
export class ListeSallesComponent implements OnInit {

  salles: SalleClasse[] = [];

  constructor(private utilisateurService: SalleClasseService) { }

  ngOnInit(): void {
    this.initList();
  }

  public initList() {
    this.utilisateurService.allSalleClasse().subscribe((data) => {
      this.salles = data;
    });
  }

  public delete(id: number) {
    this.utilisateurService.delete(id).subscribe((result) => {
      this.initList();
    });
  }

  public displayNew() {
  }

}

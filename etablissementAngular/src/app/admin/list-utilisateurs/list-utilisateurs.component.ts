import { Component, OnInit } from '@angular/core';
import { Utilisateur } from 'src/app/model/utilisateur';
import { UtilisateurService } from 'src/app/service/utilisateur.service';

@Component({
  selector: 'app-list-utilisateurs',
  templateUrl: './list-utilisateurs.component.html',
  styleUrls: ['./list-utilisateurs.component.css']
})
export class ListUtilisateursComponent implements OnInit {
  utilisateurs: Utilisateur[] = [];

  constructor(private utilisateurService: UtilisateurService) { }

  ngOnInit(): void {
    this.initList();
  }

  public initList() {
    this.utilisateurService.allUtilisateur().subscribe((data) => {
      this.utilisateurs = data;
      console.log(data);
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

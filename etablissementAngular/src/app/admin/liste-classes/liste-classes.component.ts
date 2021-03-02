import { Component, OnInit } from '@angular/core';
import { GroupeClasse } from 'src/app/model/groupe-classe';
import { GoupeclasseService } from 'src/app/service/goupeclasse.service';


@Component({
  selector: 'app-liste-classes',
  templateUrl: './liste-classes.component.html',
  styleUrls: ['./liste-classes.component.css']
})
export class ListeClassesComponent implements OnInit {
  classes: GroupeClasse[] = [];
  showNew: boolean = false;

  constructor(private utilisateurService: GoupeclasseService) { }

  ngOnInit(): void {
    this.initList();
  }

  public initList() {
    this.utilisateurService.allGroupeclasse().subscribe((data) => {
      this.classes = data;
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
import { CoursService } from './../../service/cours.service';
import { Cours } from './../../model/cours';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-liste-cours',
  templateUrl: './liste-cours.component.html',
  styleUrls: ['./liste-cours.component.css']
})
export class ListeCoursComponent implements OnInit {

  cours: Cours[] = [];
  //showNew: boolean = false;

  constructor(private coursService: CoursService) { }

  ngOnInit(): void {
    this.initList();
  }

  public initList() {
    this.coursService.allCours().subscribe((data) => {
      this.cours = data;
    });
  }

  public delete(id: number) {
    this.coursService.delete(id).subscribe((result) => {
      this.initList();
    });
  }

  public displayNew() {
  }
/*
  public displayNew() {
    this.showNew = !this.showNew;
  }

  public insert() {
    this.displayNew();
    this.initList();
  }

  public cancel() {
    this.displayNew();
  }*/
}

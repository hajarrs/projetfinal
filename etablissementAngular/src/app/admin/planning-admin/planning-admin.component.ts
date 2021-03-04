import { CoursService } from './../../service/cours.service';
import { Cours } from './../../model/cours';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'planning-admin',
  templateUrl: './planning-admin.component.html',
  styleUrls: ['./planning-admin.component.scss']
})
export class PlanningAdminComponent implements OnInit {

  constructor(private coursService: CoursService) { }

  ngOnInit() {
    this.coursService.allCours().subscribe((data) => {
      this.listeCours = data;
    });
  }

  listeCours: Cours[] = [];



}

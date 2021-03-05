import { CoursService } from './../../../service/cours.service';
import { Cours } from './../../../model/cours';
import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-cours-row, [cours-row]',
  templateUrl: './cours-row.component.html',
  styleUrls: ['./cours-row.component.css']
})
export class CoursRowComponent implements OnInit {


  @Input()
  cours: Cours = new Cours();
  edit: boolean = false;
  @Output('delete')
  deleteEvent: EventEmitter<number> = new EventEmitter();

  constructor(private coursService: CoursService) { }

 ngOnInit(): void {
    if (!this.cours.id) {
      this.changeMode();
    }
  }

  public delete() {
    this.deleteEvent.emit(this.cours.id);
  }

  public changeMode() {
    this.edit = !this.edit;
  }
}

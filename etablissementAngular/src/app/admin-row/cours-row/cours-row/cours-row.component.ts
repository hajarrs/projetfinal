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
  user: Cours = new Cours();
  edit: boolean = false;
  @Output('delete')
  deleteEvent: EventEmitter<number> = new EventEmitter();
  @Output('insert')
  insertEvent: EventEmitter<void> = new EventEmitter();
  @Output('cancel')
  cancelEvent: EventEmitter<void> = new EventEmitter();

  constructor(private coursService: CoursService) { }

  ngOnInit(): void {
    if (!this.user.id) {
      this.changeMode();
    }
  }

  public delete() {
    this.deleteEvent.emit(this.user.id);
  }

  public changeMode() {
    this.edit = !this.edit;
  }

  public cancel() {
    this.changeMode();
    if (!this.user.id) {
      console.log('here');
      this.cancelEvent.emit();
    }
  }

  public save() {
    if (this.user.id) {
      this.coursService.update(this.user).subscribe((result) => {
        this.changeMode();
      });
    } else {
      this.coursService.insert(this.user).subscribe((result) => {
        this.user.id = result.id;
        this.changeMode();
        this.insertEvent.emit();
      });
    }
  }
}

import { Component, Input, OnInit, Output,EventEmitter } from '@angular/core';
import { Professeur } from 'src/app/model/professeur';
import { ProfesseurService } from 'src/app/service/professeur.service';


@Component({
  selector: 'app-professeur-row, [professeur-row]',
  templateUrl: './professeur-row.component.html',
  styleUrls: ['./professeur-row.component.css']
})
export class ProfesseurRowComponent implements OnInit {

  @Input()
  user: Professeur = new Professeur ();
  edit: boolean = false;
  @Output('delete')
  deleteEvent: EventEmitter<number> = new EventEmitter();
  @Output('insert')
  insertEvent: EventEmitter<void> = new EventEmitter();
  @Output('cancel')
  cancelEvent: EventEmitter<void> = new EventEmitter();

  constructor(private professeurService: ProfesseurService) {}

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
      this.professeurService.update(this.user).subscribe((result) => {
        this.changeMode();
      });
    } else {
      this.professeurService.insert(this.user).subscribe((result) => {
        this.user.id = result.id;
        this.changeMode();
        this.insertEvent.emit();
      });
    }
  }
}
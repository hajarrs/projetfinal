import { Component, Input, OnInit, Output,EventEmitter } from '@angular/core';
import { Matiere } from 'src/app/model/matiere';
import { MatiereService } from 'src/app/service/matiere.service';

@Component({
  selector: 'app-matiere-row, [matiere-row]',
  templateUrl: './matiere-row.component.html',
  styleUrls: ['./matiere-row.component.css']
})
export class MatiereRowComponent implements OnInit {

  @Input()
  matiere: Matiere = new Matiere();
  edit: boolean = false;
  @Output('delete')
  deleteEvent: EventEmitter<number> = new EventEmitter();

  constructor(private matiereClasseService: MatiereService) {}

  ngOnInit(): void {
    if (!this.matiere.id) {
      this.changeMode();
    }
  }

  public delete() {
    this.deleteEvent.emit(this.matiere.id);
  }

  public changeMode() {
    this.edit = !this.edit;
  }
}
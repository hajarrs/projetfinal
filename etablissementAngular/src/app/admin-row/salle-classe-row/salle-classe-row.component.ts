import { Component, Input, OnInit, Output,EventEmitter } from '@angular/core';
import { SalleClasse } from 'src/app/model/salle-classe';
import { SalleClasseService } from 'src/app/service/salle-classe.service';

@Component({
  selector: 'app-salle-classe-row, [salle-classe-row]',
  templateUrl: './salle-classe-row.component.html',
  styleUrls: ['./salle-classe-row.component.css']
})
export class SalleClasseRowComponent implements OnInit {

  @Input()
  user: SalleClasse = new SalleClasse();
  edit: boolean = false;
  @Output('delete')
  deleteEvent: EventEmitter<number> = new EventEmitter();

  constructor(private salleClasseService: SalleClasseService) {}

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

}
import { Component, EventEmitter, Input, OnInit, Output } from "@angular/core";
import { Utilisateur } from "src/app/model/utilisateur";
import { UtilisateurService } from "src/app/service/utilisateur.service";


@Component({
  selector: 'app-utilisateur-row, [utilisateur-row]',
  templateUrl: './utilisateur-row.component.html',
  styleUrls: ['./utilisateur-row.component.css']
})
export class UtilisateurRowComponent implements OnInit {
  @Input()
  user: Utilisateur = new Utilisateur ();
  edit: boolean = false;
  @Output('delete')
  deleteEvent: EventEmitter<number> = new EventEmitter();

  constructor(private utilisateurService: UtilisateurService) {}

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

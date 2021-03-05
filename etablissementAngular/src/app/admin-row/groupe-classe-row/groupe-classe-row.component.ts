import { Component, Input, OnInit, Output,EventEmitter } from '@angular/core';
import { GroupeClasse } from 'src/app/model/groupe-classe';
import { GoupeclasseService } from 'src/app/service/goupeclasse.service';

@Component({
  selector: 'app-groupe-classe-row, [groupe-classe-row]',
  templateUrl: './groupe-classe-row.component.html',
  styleUrls: ['./groupe-classe-row.component.css']
})
export class GroupeClasseRowComponent implements OnInit {

  @Input()
  classe: GroupeClasse = new GroupeClasse();
  edit: boolean = false;
  @Output('delete')
  deleteEvent: EventEmitter<number> = new EventEmitter();

  constructor(private groupClasseService: GoupeclasseService) {}

  ngOnInit(): void {
    if (!this.classe.id) {
      this.changeMode();
    }
  }

  public delete() {
    this.deleteEvent.emit(this.classe.id);
  }

  public changeMode() {
    this.edit = !this.edit;
  }

  
}
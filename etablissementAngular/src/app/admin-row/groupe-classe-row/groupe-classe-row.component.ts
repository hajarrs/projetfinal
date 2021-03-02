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
  user: GroupeClasse = new GroupeClasse();
  edit: boolean = false;
  @Output('delete')
  deleteEvent: EventEmitter<number> = new EventEmitter();
  @Output('insert')
  insertEvent: EventEmitter<void> = new EventEmitter();
  @Output('cancel')
  cancelEvent: EventEmitter<void> = new EventEmitter();

  constructor(private groupClasseService: GoupeclasseService) {}

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
      this.groupClasseService.update(this.user).subscribe((result) => {
        this.changeMode();
      });
    } else {
      this.groupClasseService.insert(this.user).subscribe((result) => {
        this.user.id = result.id;
        this.changeMode();
        this.insertEvent.emit();
      });
    }
  }
}
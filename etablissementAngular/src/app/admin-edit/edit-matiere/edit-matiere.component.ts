import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Matiere } from 'src/app/model/matiere';
import { MatiereService } from 'src/app/service/matiere.service';

@Component({
  selector: 'app-edit-matiere',
  templateUrl: './edit-matiere.component.html',
  styleUrls: ['./edit-matiere.component.css']
})
export class EditMatiereComponent implements OnInit {
  private _matiere: Matiere = new Matiere();
  nomCtrl: FormControl;
  couleurCtrl: FormControl;
  form: FormGroup;
  private _index: number = -1;

  constructor(private activatedRoute: ActivatedRoute,private matiereService: MatiereService, private fb: FormBuilder,private router: Router) { 
    this.nomCtrl = this.fb.control('',Validators.required);
    this.couleurCtrl = this.fb.control('',Validators.required);
    
    this.form = this.fb.group({
      nom: this.nomCtrl,
      couleur: this.couleurCtrl,
    });
  }

  ngOnInit(): void {

    this.activatedRoute.params.subscribe((params) => {
    
      if (params.id) {
        
        this._index = params.id;
        this.matiereService.findById(params.id).subscribe((data) => {
          this._matiere = data;
          this.nomCtrl.setValue(this._matiere.nom);
          this.couleurCtrl.setValue(this._matiere.couleur);
          
        });
      }
    });
  }

  public send() {
    this._matiere.nom=this.nomCtrl.value;
    this._matiere.couleur=this.couleurCtrl.value;
    console.log(this._index);
    if (this._index!=-1) {
      console.log("update");
      this.matiereService.update(this._matiere).subscribe((result)=>{})
    }else{
      console.log("add");
      this.matiereService.insert(this._matiere).subscribe((result)=>{})
    }
    this.router.navigate(['/listematieres']);
    
  }

}

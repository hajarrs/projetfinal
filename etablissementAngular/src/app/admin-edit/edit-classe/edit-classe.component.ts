import { R3TargetBinder } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { GroupeClasse } from 'src/app/model/groupe-classe';
import { Professeur } from 'src/app/model/professeur';
import { GoupeclasseService } from 'src/app/service/goupeclasse.service';
import { ProfesseurService } from 'src/app/service/professeur.service';

@Component({
  selector: 'app-edit-classe',
  templateUrl: './edit-classe.component.html',
  styleUrls: ['./edit-classe.component.css']
})
export class EditClasseComponent implements OnInit {
  private _classe: GroupeClasse = new GroupeClasse();
  nomCtrl: FormControl;
  professeurCtrl: FormControl;
  form: FormGroup;
  private _index: number = -1;
  professeurs: Professeur[] = [];
  professeurTpm: Professeur = new Professeur();
  idProfresseur: number=0;

  constructor(private activatedRoute: ActivatedRoute, private fb: FormBuilder,private router: Router,
    private classeService: GoupeclasseService,private professeurService: ProfesseurService) { 
      this.nomCtrl = this.fb.control('',Validators.required);
      this.professeurCtrl = this.fb.control('',Validators.min(0));
    
    this.form = this.fb.group({
      nom: this.nomCtrl,
      professeur: this.professeurCtrl,
    });
    }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
    
      if (params.id) { 
        this._index = params.id;
        this.classeService.findById(params.id).subscribe((data) => {
          this._classe = data;
          this.idProfresseur=data.professeurPrincipal.id;
          this.nomCtrl.setValue(this._classe.nom);
          this.professeurCtrl.setValue(this._classe.professeurPrincipal);
          this.professeurTpm = data.professeurPrincipal;
          
        });
      }

      console.log("test");
      this.professeurService.allProfesseur().subscribe((data) => {
        this.professeurs=data;
      })


        

    });
  }

  public send() {
    this._classe.nom=this.nomCtrl.value;
    this._classe.professeurPrincipal=this.professeurTpm;
    console.log(this._index);
    if (this._index!=-1) {
      this.classeService.update(this._classe).subscribe((result)=>{})
    }else{
      this.classeService.insert(this._classe).subscribe((result)=>{})
    }
    this.router.navigate(['/listeclasses']);
    
  }

  public professeurSelect(evt:any){
    console.log(evt.target.value);
    this.professeurService.findById(evt.target.value).subscribe((data) => {
      this.professeurTpm = data;
    });
  }


      /**
     * Getter classe
     * @return {GroupeClasse }
     */
	public get classe(): GroupeClasse  {
		return this._classe;
	}

    /**
     * Setter classe
     * @param {GroupeClasse } value
     */
	public set classe(value: GroupeClasse ) {
		this._classe = value;
	}
}

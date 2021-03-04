import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Matiere } from 'src/app/model/matiere';
import { SalleClasse } from 'src/app/model/salle-classe';
import { MatiereService } from 'src/app/service/matiere.service';
import { SalleClasseService } from 'src/app/service/salle-classe.service';

@Component({
  selector: 'app-edit-salle',
  templateUrl: './edit-salle.component.html',
  styleUrls: ['./edit-salle.component.css']
})
export class EditSalleComponent implements OnInit {
  private _salle: SalleClasse = new SalleClasse();
  nomCtrl: FormControl;
  matieresExcluesCtrl: FormControl;
  capaciteCtrl: FormControl;
  form: FormGroup;
  idMatiereExclues: number[] =[];
  matieres: Matiere[] = [];
  checkboxlist: FormGroup;
  private _index: number = -1;
  

  constructor(private activatedRoute: ActivatedRoute, private salleService: SalleClasseService,
    private matiereService: MatiereService, private fb: FormBuilder,private router: Router) { 
    this.nomCtrl = this.fb.control('',Validators.required);
    this.matieresExcluesCtrl = this.fb.control('');
    this.capaciteCtrl = this.fb.control('',Validators.required);
    this.checkboxlist = this.fb.group({});
    this.form = this.fb.group({
      nom: this.nomCtrl,
      matieresExclues: this.matieresExcluesCtrl,
      capacite: this.capaciteCtrl,
      checkboxList : this.checkboxlist
    });

    
    
  }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
    
      if (params.id) {
        
        this._index = params.id;
        this.salleService.findById(params.id).subscribe((data) => {
          this._salle = data;
          this.nomCtrl.setValue(this.salle.nom);
          this.matieresExcluesCtrl.setValue(this.salle.matieresExclues);
          this.capaciteCtrl.setValue(this.salle.capacite);
          for (let matiere of data.matieresExclues) {
            this.idMatiereExclues.push(matiere.id);
          }
          console.log("id matieres exclues" + this.idMatiereExclues);
        });
      }
    });

    this.matiereService.allMatiere().subscribe((data) =>{
      this.matieres=data;
    

    const selectedcheck = this.form.get('checkboxList') as FormGroup;
    this.matieres.forEach(matiere => {
      const selected : FormControl = this.fb.control(this.idMatiereExclues.includes(matiere.id) ? matiere.id : null);
      
      selectedcheck.addControl(matiere.nom,selected); 
    });
  })
  }

  public changeState(event:any,id:number, nom:string) {
    /* Selected */
    if (event.target.checked) {
      this.form.get('checkboxList')?.get(nom)?.setValue(id);
      event.target.value=id;
    /* Unselected */
    } else {
      this.form.get('checkboxList')?.get(nom)?.setValue(null);
      event.target.value=null;
    }
    
  }
  public send() {
    this.salle.nom=this.nomCtrl.value;
    this.salle.capacite=this.capaciteCtrl.value;
    console.log(this.form.get('checkboxList')?.value);
    const listmatiere: any[] = [];

    for (let control in this.form.get('checkboxList')?.value) {
      if(this.form.get('checkboxList')?.value[control]){
          listmatiere.push({"id":this.form.get('checkboxList')?.value[control]});
      }
   
    }
    this.salle.matieresExclues=listmatiere;
    console.log("this._index"+this._index);
    if (this._index!=-1) {
      console.log('update');
      this.salleService.update(this.salle).subscribe((result)=>{})
    }else{
      console.log('add');
      this.salleService.insert(this.salle).subscribe((result)=>{})
    }
    this.router.navigate(['/listesalles']);
    console.log("test mtieresexclues"+this.salle.matieresExclues.values);
    
  }
    

      /**
     * Getter salle
     * @return {SalleClasse }
     */
	public get salle(): SalleClasse  {
		return this._salle;
	}

    /**
     * Setter salle
     * @param {Salarie } value
     */
	public set salle(value: SalleClasse ) {
		this._salle = value;
	}
  
}

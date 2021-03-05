import { SalleClasse } from './../../model/salle-classe';
import { MatiereService } from 'src/app/service/matiere.service';
import { ProfesseurService } from 'src/app/service/professeur.service';
import { CoursService } from './../../service/cours.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FormControl, FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Cours } from './../../model/cours';
import { Component, OnInit } from '@angular/core';
import { SalleClasseService } from 'src/app/service/salle-classe.service';
import { Professeur } from 'src/app/model/professeur';
import { Matiere } from 'src/app/model/matiere';

@Component({
  selector: 'app-edit-cours',
  templateUrl: './edit-cours.component.html',
  styleUrls: ['./edit-cours.component.css']
})
export class EditCoursComponent implements OnInit {

  private _cours: Cours = new Cours();
  nomCtrl: FormControl;
  professeurCtrl: FormControl;
  matiereCtrl: FormControl;
  classeCtrl: FormControl;
  form: FormGroup;
  professeurTpm: Professeur = new Professeur();
  matiereTmp: Matiere = new Matiere();
  classeTmp: SalleClasse = new SalleClasse();
  professeurs: Professeur[] = [];
  matieres : Matiere[] = [];
  classes : SalleClasse[]=[];
  private _index: number = -1;
  idProfresseur: number=0;
  idMatiere: number=0;
  idclasse: number=0;

  constructor(private activatedRoute: ActivatedRoute,private coursService: CoursService, private fb: FormBuilder,private router: Router,
    private professeurService: ProfesseurService, private matiereService: MatiereService, private classeService: SalleClasseService) {

    this.nomCtrl = this.fb.control('',Validators.required);
    this.professeurCtrl = this.fb.control('',Validators.min(0));
    this.matiereCtrl = this.fb.control('',Validators.min(0));
    this.classeCtrl = this.fb.control('',Validators.min(0));

    this.form = this.fb.group({
      nom: this.nomCtrl,
      professeur: this.professeurCtrl,
      matiere: this.professeurCtrl,
      classe: this.professeurCtrl,
    });

  }

  ngOnInit(): void {

    this.activatedRoute.params.subscribe((params) => {

      if (params.id) {

        this._index = params.id;
        this.coursService.findById(params.id).subscribe((data) => {
          this._cours = data;
          this.nomCtrl.setValue(this._cours.heureDebut);
          this.nomCtrl.setValue(this._cours.heureFin);
          this.nomCtrl.setValue(this._cours.day);
          this.nomCtrl.setValue(this._cours.matiere);
          this.nomCtrl.setValue(this._cours.professeur);
          this.nomCtrl.setValue(this._cours.salle);
          this.idProfresseur=data.professeur.id;
          this.idMatiere=data.matiere.id;
          this.idclasse=data.salle.id;
          this.professeurCtrl.setValue(this._cours.professeur);
          this.matiereCtrl.setValue(this._cours.matiere);
          this.classeCtrl.setValue(this._cours.salle);

        });
      }
      this.professeurService.allProfesseur().subscribe((data) => {
        this.professeurs=data;
      })

      this.matiereService.allMatiere().subscribe((data) => {
        this.matieres=data;
      })

      this.classeService.allSalleClasse().subscribe((data) => {
        this.classes=data;
      })
    });
  }
  public send() {
    //this._cours.heureFin=this.nomCtrl.value;
    //this._cours.couleur=this.couleurCtrl.value;
    //console.log(this._index);
    this._cours.professeur=this.professeurTpm;
    this._cours.matiere=this.matiereTmp;
    this._cours.salle=this.classeTmp;
    if (this._index!=-1) {
     // console.log("update");
      this.coursService.update(this._cours).subscribe((result)=>{})
    }else{
     // console.log("add");
      this.coursService.insert(this._cours).subscribe((result)=>{})
    }
    this.router.navigate(['/listecours']);

  }


  public professeurSelect(evt:any){
    console.log(evt.target.value);
    this.professeurService.findById(evt.target.value).subscribe((data) => {
      this.professeurTpm = data;
    });
  }
  public matiereSelect(evt:any){
    console.log(evt.target.value);
    this.matiereService.findById(evt.target.value).subscribe((data) => {
      this.matiereTmp = data;
    });
  }
  public classeSelect(evt:any){
    console.log(evt.target.value);
    this.classeService.findById(evt.target.value).subscribe((data) => {
      this.classeTmp = data;
    });
  }

    /**
     * Getter cours
     * @return {Cours }
     */
	public get cours(): Cours  {
		return this._cours;
	}

    /**
     * Setter cours
     * @param {Cours } value
     */
	public set cours(value: Cours ) {
		this._cours = value;
	}

}

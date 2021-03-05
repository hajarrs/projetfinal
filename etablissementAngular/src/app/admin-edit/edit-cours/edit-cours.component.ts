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
  heureDebutCtrl: FormControl;
  heureFinCtrl: FormControl;
  dayCtrl: FormControl;
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

    this.heureDebutCtrl = this.fb.control('',Validators.required);
    this.heureFinCtrl = this.fb.control('',Validators.required);
    this.dayCtrl = this.fb.control('',Validators.required);
    this.professeurCtrl = this.fb.control('',Validators.min(0));
    this.matiereCtrl = this.fb.control('',Validators.min(0));
    this.classeCtrl = this.fb.control('',Validators.min(0));

    this.form = this.fb.group({
      heureDebut: this.heureDebutCtrl,
      heureFin: this.heureFinCtrl,
      day: this.dayCtrl,
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
          this.heureDebutCtrl.setValue(this._cours.heureDebut);
          this.heureFinCtrl.setValue(this._cours.heureFin);
          this.dayCtrl.setValue(this._cours.day);
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
    this._cours.heureDebut=this.heureDebutCtrl.value;
    this._cours.heureFin=this.heureFinCtrl.value;
    this._cours.day=this.dayCtrl.value;
    console.log(this._cours);
    console.log(this._cours.day);

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
    this.professeurTpm=this.professeurs[evt.target.value];
    console.log(this.professeurTpm);
  }
  public matiereSelect(evt:any){
    this.matiereTmp=this.matieres[evt.target.value];
    console.log(this.matiereTmp);
  }
  public classeSelect(evt:any){
    this.classeTmp=this.classes[evt.target.value];
    console.log(this.classeTmp);
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

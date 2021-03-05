import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Adresse } from 'src/app/model/adresse';
import { Etablissement } from 'src/app/model/etablissement';
import { Login } from 'src/app/model/login';
import { Professeur } from 'src/app/model/professeur';
import { Utilisateur } from 'src/app/model/utilisateur';
import { EtablissementService } from 'src/app/service/etablissement.service';
import { UtilisateurService } from 'src/app/service/utilisateur.service';

@Component({
  selector: 'app-edit-utilisateur',
  templateUrl: './edit-utilisateur.component.html',
  styleUrls: ['./edit-utilisateur.component.css']
})
export class EditUtilisateurComponent implements OnInit {


    
  private _utilisateur: Utilisateur = new Utilisateur();
  private _login: Login = new Login();
  private _adresse: Adresse = new Adresse();
  loginCtrl: FormControl;
  nomCtrl: FormControl;
  prenomCtrl: FormControl;
  nomRueCtrl: FormControl;
  numRueCtrl: FormControl;
  codePostalCtrl: FormControl;
  villeCtrl: FormControl;
  dateNaissanceCtrl: FormControl;
  etablissementCtrl: FormControl;
  form: FormGroup;
  private _index: number = -1;
  etablissements: Etablissement[] = [];
  idEtablissement: number =-1;
  etablissmentTpm : Etablissement = new Etablissement();

  constructor(private activatedRoute: ActivatedRoute,private etablissementService: EtablissementService,
     private utilisateurService: UtilisateurService, private fb: FormBuilder,private router: Router) {
      this.loginCtrl = this.fb.control('',Validators.required);
      this.nomCtrl = this.fb.control('',Validators.required);
      this.prenomCtrl = this.fb.control('',Validators.required);
      this.nomRueCtrl = this.fb.control('',Validators.required);
      this.numRueCtrl = this.fb.control('',Validators.required);
      this.codePostalCtrl = this.fb.control('',Validators.required);
      this.villeCtrl = this.fb.control('',Validators.required);
      this.dateNaissanceCtrl = this.fb.control('',Validators.required);
      this.etablissementCtrl = this.fb.control('',Validators.min(0));

      
      this.form = this.fb.group({
        login: this.loginCtrl,
        nom: this.nomCtrl,
        prenom : this.prenomCtrl,
        nomRue: this.nomRueCtrl,
        numRue: this.numRueCtrl,
        codeProstal: this.codePostalCtrl,
        ville: this.villeCtrl,
        dateNaissance: this.dateNaissanceCtrl,
        etablissement: this.etablissementCtrl
      });
      }

  ngOnInit(): void {

    this.activatedRoute.params.subscribe((params) => {
    
      if (params.id) {
        
        this._index = params.id;
        this.utilisateurService.findById(params.id).subscribe((data) => {
          this._utilisateur = data;
          this.loginCtrl.setValue(this._utilisateur.login.login);
          this.nomCtrl.setValue(this._utilisateur.nom);
          this.prenomCtrl.setValue(this._utilisateur.prenom);
          this.nomRueCtrl.setValue(this._utilisateur.adresse.nomRue);
          this.numRueCtrl.setValue(this._utilisateur.adresse.numRue);
          this.codePostalCtrl.setValue(this._utilisateur.adresse.codePostal);
          this.villeCtrl.setValue(this._utilisateur.adresse.ville);
          this.dateNaissanceCtrl.setValue(this._utilisateur.dateNaissance);
          this.etablissementCtrl.setValue(this._utilisateur.etablissement);
          this.idEtablissement=this.utilisateur.etablissement.id;
          this.etablissmentTpm=this.utilisateur.etablissement;
          this.login=this.utilisateur.login;
          this.adresse=this.utilisateur.adresse;
        });
      }

      this.etablissementService.allEtablissement().subscribe((data)=>{
        this.etablissements=data;
      })
    });

    
  }
  public send(){


    this.login.login=this.loginCtrl.value;
    //this.login.password="tmp";

    this.adresse.nomRue=this.nomRueCtrl.value;
    this.adresse.numRue=this.numRueCtrl.value;
    this.adresse.codePostal=this.codePostalCtrl.value;
    this.adresse.ville=this.villeCtrl.value;

    this.utilisateur.adresse=this.adresse;
    this.utilisateur.login=this.login;
    this.utilisateur.nom=this.nomCtrl.value;
    this.utilisateur.prenom=this.prenomCtrl.value;
    this.utilisateur.dateNaissance=this.dateNaissanceCtrl.value;
    this.utilisateur.etablissement=this.etablissmentTpm;
    

    if (this._index!=-1) {
      this.utilisateurService.update(this.utilisateur).subscribe((result)=>{})
    }else{
      this.utilisateur.login.typeUtilisateur="UTILISATEUR";
      this.utilisateurService.insert(this.utilisateur).subscribe((result)=>{})
    }
    this.router.navigate(['/listeutilisateurs']);

      }

      public etablissementSelect(evt:any){
        this.etablissementService.findById(evt.target.value).subscribe((data) => {
          this.etablissmentTpm = data;
        });
      }

      /**
     * Getter utilisateur
     * @return {Utilisateur }
     */
	public get utilisateur(): Utilisateur  {
		return this._utilisateur;
	}

    /**
     * Setter utilisateur
     * @param {Utilisateur } value
     */
	public set utilisateur(value: Utilisateur ) {
		this._utilisateur = value;
	}


    /**
     * Getter login
     * @return {Login }
     */
	public get login(): Login  {
		return this._login;
	}

    /**
     * Getter adresse
     * @return {Adresse }
     */
	public get adresse(): Adresse  {
		return this._adresse;
	}

    /**
     * Getter index
     * @return {number }
     */
	public get index(): number  {
		return this._index;
	}

    /**
     * Setter login
     * @param {Login } value
     */
	public set login(value: Login ) {
		this._login = value;
	}

    /**
     * Setter adresse
     * @param {Adresse } value
     */
	public set adresse(value: Adresse ) {
		this._adresse = value;
	}

    /**
     * Setter index
     * @param {number } value
     */
	public set index(value: number ) {
		this._index = value;
	}

}

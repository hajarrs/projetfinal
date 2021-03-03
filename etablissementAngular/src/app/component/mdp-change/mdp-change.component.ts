import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Professeur } from 'src/app/model/professeur';
import { Utilisateur } from 'src/app/model/utilisateur';
import { UtilisateurService } from 'src/app/service/utilisateur.service';

@Component({
  selector: 'app-mdp-change',
  templateUrl: './mdp-change.component.html',
  styleUrls: ['./mdp-change.component.css']
})
export class MdpChangeComponent implements OnInit {
  private _utilisateur: Utilisateur = new Utilisateur();
  private _professeur: Professeur = new Professeur();

  pswCtrl: FormControl;
  form: FormGroup;

  pswConfirmeCtrl: FormControl;
  
  constructor(private activatedRoute: ActivatedRoute, private utilisateurService: UtilisateurService, private router: Router,private fb: FormBuilder) {
    this.pswCtrl=this.fb.control('', [
      Validators.minLength(3), 
      Validators.pattern(/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])([a-zA-Z0-9]{3,})$/)]);
    this.pswConfirmeCtrl = this.fb.control('');
    this.form=this.fb.group({
      psw: this.pswCtrl,
      pswConfirme: this.pswConfirmeCtrl,
    },{ validator: this.erreurNotSame});
   }

   erreurNotSame(group: FormGroup) {
    const pswC = group.controls['psw'];
    const pswConfirmeC = group.controls['pswConfirme'];

    if (pswC.value !== pswConfirmeC.value) {
      return { monErreur: true };
    }
    return null;
  }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params.id) {
        this.utilisateurService.findById(params.id).subscribe((data) => {
          this._utilisateur=data;
        });
      }
    });
  }

  public send() {
    console.log("send");
    this.utilisateur.login.password=this.pswCtrl.value;

    this.utilisateurService.update(this.utilisateur).subscribe((result)=>{
      //sessionStorage.removeItem('tokenId');
      sessionStorage.setItem('tokenId', btoa(`${sessionStorage.getItem('login')}:${this.utilisateur.login.password}`));
      if (sessionStorage.getItem('typeUtilisateur') == "ADMIN") {
        console.log("admin");
          this.router.navigate(['/homeadmin']);
        } else {
          console.log("utlisateur");
          this.router.navigate(['/homeadmin']);
        }
    })
      
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

}

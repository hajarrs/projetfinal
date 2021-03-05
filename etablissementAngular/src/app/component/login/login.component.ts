import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Login } from 'src/app/model/login';
import { Professeur } from 'src/app/model/professeur';
import { LoginService } from 'src/app/service/login.service';
import { ProfesseurService } from 'src/app/service/professeur.service';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginCtrl: FormControl;
  pswCtrl: FormControl;
  form: FormGroup;
  erreur: boolean = false;

  constructor(private loginService: LoginService, private router: Router,private fb: FormBuilder) {
    this.loginCtrl=this.fb.control('',Validators.required);
    this.pswCtrl=this.fb.control('',Validators.required);
    this.form=this.fb.group({
      monLogin: this.loginCtrl,
      psw: this.pswCtrl,
    });

   }

  ngOnInit(): void {
  }

  public logging() {
    this.loginService.auth(new Login(this.loginCtrl.value,this.pswCtrl.value)).subscribe(
      (result) => {
        sessionStorage.setItem(
          'tokenId',
          btoa(`${this.loginCtrl.value}:${this.pswCtrl.value}`)
        );
        sessionStorage.setItem('login', result.login.login);
        sessionStorage.setItem('identifiant', ""+result.id);
        sessionStorage.setItem('typeUtilisateur', result.login.typeUtilisateur);
        if (result.login.premiereConnexion) {
          this.router.navigate(['/mdpchange/' + result.id]);
        } else {
          if (result.login.typeUtilisateur == "ADMIN") {
            this.router.navigate(['/homeadmin']);
          } else {
            this.router.navigate(['/homeadmin']);
          }
        }


      },
      (error) => {
        this.erreur = true;
      }
    );
  }
}

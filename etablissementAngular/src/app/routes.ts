import { Routes } from "@angular/router";
import { AppComponent } from "./app.component";
import { LoginComponent } from "./component/login/login.component";
import { HomeAdminComponent } from './admin/home-admin/home-admin.component';
import { ListeClassesComponent } from './admin/liste-classes/liste-classes.component';
import { ListeMatieresComponent } from './admin/liste-matieres/liste-matieres.component';
import { ListeProfesseursComponent } from './admin/liste-professeurs/liste-professeurs.component';
import { ListeSallesComponent } from './admin/liste-salles/liste-salles.component';


export const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'homeadmin', component: HomeAdminComponent},
  { path: 'listeclasses', component: ListeClassesComponent},
  { path: 'listematieres', component: ListeMatieresComponent},
  { path: 'listeprofesseurs', component: ListeProfesseursComponent},
  { path: 'listesalles', component: ListeSallesComponent},
  { path: '', redirectTo: 'login', pathMatch: 'full' }
];
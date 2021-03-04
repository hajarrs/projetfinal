import { PlanningProfComponent } from './prof/planning-prof/planning-prof.component';
import { PlanningAdminComponent } from './admin/planning-admin/planning-admin.component';
import { ListeCoursComponent } from './admin/liste-cours/liste-cours.component';
import { Routes } from "@angular/router";
import { AppComponent } from "./app.component";
import { LoginComponent } from "./component/login/login.component";
import { HomeAdminComponent } from './admin/home-admin/home-admin.component';
import { ListeClassesComponent } from './admin/liste-classes/liste-classes.component';
import { ListeMatieresComponent } from './admin/liste-matieres/liste-matieres.component';
import { ListeProfesseursComponent } from './admin/liste-professeurs/liste-professeurs.component';
import { ListeSallesComponent } from './admin/liste-salles/liste-salles.component';
import { PlanningComponent } from "./planning/planning.component";
import { MdpChangeComponent } from "./component/mdp-change/mdp-change.component";
import { ListUtilisateursComponent } from "./admin/list-utilisateurs/list-utilisateurs.component";


export const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'homeadmin', component: HomeAdminComponent},
  { path: 'listeclasses', component: ListeClassesComponent},
  { path: 'listematieres', component: ListeMatieresComponent},
  { path: 'listeprofesseurs', component: ListeProfesseursComponent},
  { path: 'listeutilisateurs', component: ListUtilisateursComponent},
  { path: 'listesalles', component: ListeSallesComponent},
  { path: 'listecours', component: ListeCoursComponent},
  { path: 'planning', component: PlanningComponent },
  { path: 'planning-admin', component: PlanningAdminComponent},
  { path: 'planning-prof', component: PlanningProfComponent},
  { path: 'mdpchange/:id', component: MdpChangeComponent },
  { path: '', redirectTo: 'login', pathMatch: 'full' }
];

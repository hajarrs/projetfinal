import { SallePipe } from './filter/salle.pipe';
import { ProfPipe } from './filter/prof.pipe';
import { PlanningProfComponent } from './prof/planning-prof/planning-prof.component';
import { PlanningAdminComponent } from './admin/planning-admin/planning-admin.component';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './component/login/login.component';
import { routes } from './routes';


import { HomeAdminComponent } from './admin/home-admin/home-admin.component';
import { ListeClassesComponent } from './admin/liste-classes/liste-classes.component';
import { ListeMatieresComponent } from './admin/liste-matieres/liste-matieres.component';
import { ListeProfesseursComponent } from './admin/liste-professeurs/liste-professeurs.component';
import { ListeSallesComponent } from './admin/liste-salles/liste-salles.component';



import { SalleClasseRowComponent } from './admin-row/salle-classe-row/salle-classe-row.component';
import { MatiereRowComponent } from './admin-row/matiere-row/matiere-row.component';
import { ProfesseurRowComponent } from './admin-row/professeur-row/professeur-row.component';
import { GroupeClasseRowComponent } from './admin-row/groupe-classe-row/groupe-classe-row.component';
import { PlanningComponent } from './planning/planning.component';
import { MdpChangeComponent } from './component/mdp-change/mdp-change.component';
import { CoursRowComponent } from './admin-row/cours-row/cours-row/cours-row.component';
import { ListeCoursComponent } from './admin/liste-cours/liste-cours.component';
import { ListUtilisateursComponent } from './admin/list-utilisateurs/list-utilisateurs.component';
import { UtilisateurRowComponent } from './admin-row/utilisateur-row/utilisateur-row.component';
import { EditSalleComponent } from './admin-edit/edit-salle/edit-salle.component';
import { EditMatiereComponent } from './admin-edit/edit-matiere/edit-matiere.component';
import { EditClasseComponent } from './admin-edit/edit-classe/edit-classe.component';
import { EditUtilisateurComponent } from './admin-edit/edit-utilisateur/edit-utilisateur.component';
import { EditCoursComponent } from './admin-edit/edit-cours/edit-cours.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
HomeAdminComponent,
    ListeClassesComponent,
    ListeSallesComponent,
    ListeProfesseursComponent,
    ListeMatieresComponent,
    SalleClasseRowComponent,
    MatiereRowComponent,
    ProfesseurRowComponent,
    GroupeClasseRowComponent,
    PlanningComponent,
    PlanningAdminComponent,
    PlanningProfComponent,
    MdpChangeComponent,
    CoursRowComponent,
    ListeCoursComponent,
    ListUtilisateursComponent,
    UtilisateurRowComponent,
    EditSalleComponent,
    EditMatiereComponent,
    EditClasseComponent,
    ProfPipe,
    SallePipe,
    EditUtilisateurComponent,
    EditCoursComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  providers: [ProfPipe, SallePipe],
  bootstrap: [AppComponent]
})
export class AppModule { }

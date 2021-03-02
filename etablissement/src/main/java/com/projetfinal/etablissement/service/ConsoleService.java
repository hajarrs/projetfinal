package com.projetfinal.etablissement.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.projetfinal.etablissement.entity.Adresse;
import com.projetfinal.etablissement.entity.Cours;
import com.projetfinal.etablissement.entity.Etablissement;
import com.projetfinal.etablissement.entity.GroupeClasse;
import com.projetfinal.etablissement.entity.Login;
import com.projetfinal.etablissement.entity.Matiere;
import com.projetfinal.etablissement.entity.Professeur;
import com.projetfinal.etablissement.entity.SalleClasse;
import com.projetfinal.etablissement.entity.TypeEtablissement;
import com.projetfinal.etablissement.entity.TypeUtilisateur;
import com.projetfinal.etablissement.entity.Utilisateur;


@Service
public class ConsoleService implements CommandLineRunner {

	@Autowired
	private EtablissementService etablissementService;
	@Autowired
	private UtilisateurService utilisateurService;
	@Autowired
	private ProfesseurService professeurService;
	@Autowired
	private MatiereService matiereService;
	@Autowired
	private SalleClasseService salleClasseService;
	@Autowired
	private CoursService coursService;
	@Autowired
	private GroupeClasseService groupeService;
	

	@Override
	public void run(String... args) throws Exception {

		testsLogin();
		//testsCours();
	}

	
	private void testsLogin() {
		Adresse adresse1 = new Adresse("Rue Rouge", 1, "06000", "Nice");
		Adresse adresse2 = new Adresse("Rue vert", 1, "06000", "Nice");
		Adresse adresse3 = new Adresse("Rue bleu", 1, "06000", "Nice");
		Etablissement etablissement1 = new Etablissement("College", adresse1, TypeEtablissement.COLLEGE, "0600000001", "logo");
		etablissement1 = etablissementService.save(etablissement1);
		Etablissement etablissement2 = new Etablissement("Lycee", adresse2, TypeEtablissement.LYCEE, "0600000002", "logo");
		etablissement2 = etablissementService.save(etablissement2);
		Etablissement etablissement3 = new Etablissement("Ecole", adresse3, TypeEtablissement.ECOLE, "0600000003", "logo");
		etablissement3 = etablissementService.save(etablissement3);
		
		
		
		Login login = new Login("hajars", "hajar1", TypeUtilisateur.UTILISATEUR);
		Adresse adresse = new Adresse("Chemin des monts", 1, "13127", "Vitrolles");
		LocalDate dateNaissance1 = LocalDate.of(1995, Month.JUNE, 15);
		Professeur professeur = new Professeur(login, "ram", "hajar", adresse, dateNaissance1, etablissement1);
		
		
		SalleClasse salle = new SalleClasse("salle1", 30);
		salle = salleClasseService.save(salle);
		LocalDateTime dateHeureDebut = LocalDateTime.of(2022, Month.JANUARY, 3,8, 0);
		LocalDateTime dateHeureFin = LocalDateTime.of(2022, Month.JANUARY, 3,10, 0);
		Matiere matiere = new Matiere("Maths", "blue");
		matiereService.save(matiere);
		List<Matiere> matieres = new ArrayList<Matiere>();
		matieres.add(matiere);
		professeur.setMatieres(matieres);
		Matiere matiere2 = new Matiere("Physique", "red");
		matiereService.save(matiere2);
		List<Matiere> matieresExclues = new ArrayList<Matiere>();
		matieresExclues.add(matiere2);
		salle.setMatieresExclues(matieresExclues);
		
		
		Cours cours = new Cours(dateHeureDebut, dateHeureFin, professeur, matiere, salle, 3);
		cours.setMatiere(matiere);
		cours.setProfesseur(professeur);
		cours.setSalle(salle);
		professeur = professeurService.creationProfesseur(professeur);
		cours = coursService.save(cours);
		
		salle = salleClasseService.save(salle);
		
		professeurService.save(professeur);
		GroupeClasse groupe = new GroupeClasse("A", professeur);
		groupe = groupeService.save(groupe);
		
		Adresse adresse4 = new Adresse("Rue violet", 2, "06000", "Nice");
		LocalDate dateNaissance = LocalDate.of(1968, Month.JANUARY, 1);
		Login login1 = new Login("admin", "pass", TypeUtilisateur.ADMIN);
		Utilisateur utilisateur1 = new Utilisateur(login1, "admin", "admin", adresse4, dateNaissance, etablissement1);
		utilisateurService.creationUtilisateur(utilisateur1);
		Login login2 = new Login("user", "pass", TypeUtilisateur.UTILISATEUR);
		Utilisateur utilisateur2 = new Utilisateur(login2, "user", "user", adresse4, dateNaissance, etablissement2);
		utilisateurService.creationUtilisateur(utilisateur2);
		

		Login login3 = new Login("TestPass", TypeUtilisateur.UTILISATEUR);
		Utilisateur testUserGeneratePassword = new Utilisateur(login3, "userTestPass", "userTestPass", adresse4, dateNaissance, etablissement2);
		System.out.println("\n\n\n Password temp = " + login3.getPassword());
		utilisateurService.creationUtilisateur(testUserGeneratePassword);
	}
	
	
	private void testsCours() {
		Adresse adresse1 = new Adresse("Rue Rouge", 1, "06000", "Nice");
		Etablissement etablissement1 = new Etablissement("College", adresse1, TypeEtablissement.COLLEGE, "0600000001", "logo");
		etablissement1 = etablissementService.save(etablissement1);
		
		
		
		Login login = new Login("hajars1", "hajar1", TypeUtilisateur.UTILISATEUR);
		Adresse adresse = new Adresse("Chemin des monts", 1, "13127", "Vitrolles");
		LocalDate dateNaissance1 = LocalDate.of(1995, Month.JUNE, 15);
		Professeur professeurBioMath = new Professeur(login, "ram", "hajar", adresse, dateNaissance1, etablissement1);
		

		Login login2 = new Login("hajars2", "hajar2", TypeUtilisateur.UTILISATEUR);
		Adresse adresse2 = new Adresse("Chemin des monts", 1, "13127", "Vitrolles");
		LocalDate dateNaissance2 = LocalDate.of(1995, Month.JUNE, 15);
		Professeur professeurBio = new Professeur(login2, "ram2", "hajar2", adresse2, dateNaissance2, etablissement1);

		
		
		SalleClasse sallePolyvalente = new SalleClasse("salle1", 30);
		sallePolyvalente = salleClasseService.save(sallePolyvalente);

		SalleClasse salleStandard = new SalleClasse("salle2", 30);
		salleStandard = salleClasseService.save(salleStandard);

		

		Matiere matiereMath = new Matiere("Maths", "blue");
		matiereService.save(matiereMath);

		Matiere matiereBio = new Matiere("Bio", "green");
		matiereService.save(matiereBio);

		
		List<Matiere> matieres1 = new ArrayList<Matiere>();
		matieres1.add(matiereMath);
		matieres1.add(matiereBio);
		professeurBioMath.setMatieres(matieres1);
		
		List<Matiere> matieres2 = new ArrayList<Matiere>();
		matieres2.add(matiereBio);
		professeurBio.setMatieres(matieres2);
		
		professeurService.save(professeurBio);
		professeurService.save(professeurBioMath);
		
		
		List<Matiere> matieresExclues = new ArrayList<Matiere>();
		matieresExclues.add(matiereBio);
		salleStandard.setMatieresExclues(matieresExclues);
		
		salleClasseService.save(salleStandard);
		salleClasseService.save(sallePolyvalente);
		

		LocalDateTime dateHeureDebut1 = LocalDateTime.of(2022, Month.JANUARY, 3,8, 0);
		LocalDateTime dateHeureFin1 = LocalDateTime.of(2022, Month.JANUARY, 3,10, 0);
		LocalDateTime dateHeureDebut2 = LocalDateTime.of(2022, Month.JANUARY, 3,9, 0);
		LocalDateTime dateHeureFin2 = LocalDateTime.of(2022, Month.JANUARY, 3,11, 0);
		LocalDateTime dateHeureDebut3 = LocalDateTime.of(2022, Month.JANUARY, 3,10, 0);
		LocalDateTime dateHeureFin3 = LocalDateTime.of(2022, Month.JANUARY, 3,12, 0);

		
		Cours cours1 = new Cours(dateHeureDebut1, dateHeureFin1, professeurBio, matiereMath, salleStandard, 3);
		System.out.println("retour attendu null (prof ne donne pas de cours de math) : " + coursService.save(cours1));
		
		cours1 = new Cours(dateHeureDebut1, dateHeureFin1, professeurBio, matiereBio, salleStandard, 3);
		System.out.println("retour attendu null (bio pas possible dans la salle) : " + coursService.save(cours1));

		cours1 = new Cours(dateHeureDebut1, dateHeureFin1, professeurBio, matiereBio, sallePolyvalente, 3);
		cours1 = coursService.save(cours1);
		System.out.println("retour attendu non null : " + cours1);

		Cours cours2 = new Cours(dateHeureDebut2, dateHeureFin2, professeurBioMath, matiereMath, sallePolyvalente, 3);
		System.out.println("retour attendu null (salle déja occupée sur ce créneau) : " + coursService.save(cours2));
		
		cours2 = new Cours(dateHeureDebut2, dateHeureFin2, professeurBio, matiereBio, salleStandard, 2);
		System.out.println("retour attendu null (prof déja occupé sur ce créneau dans une autre salle) : " + coursService.save(cours2));
		
		cours2 = new Cours(dateHeureDebut2, dateHeureFin2, professeurBioMath, matiereMath, salleStandard, 3);
		cours2 = coursService.save(cours2);
		System.out.println("retour attendu non null : " + cours2);

		Cours cours3 = new Cours(dateHeureDebut3, dateHeureFin3, professeurBioMath, matiereBio, sallePolyvalente, 3);
		System.out.println("retour attendu null (prof déja occupé sur ce créneau dans une autre salle) : " + coursService.save(cours3));
		
		cours3 = new Cours(dateHeureDebut3, dateHeureFin3, professeurBio, matiereBio, sallePolyvalente, 3);
		cours3 = coursService.save(cours3);
		System.out.println("retour attendu non null : " + cours3);
		
	}
	
	
}

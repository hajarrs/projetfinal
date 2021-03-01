package com.projetfinal.etablissement.service;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.projetfinal.etablissement.entity.Adresse;
import com.projetfinal.etablissement.entity.Etablissement;
import com.projetfinal.etablissement.entity.Login;
import com.projetfinal.etablissement.entity.Professeur;
import com.projetfinal.etablissement.entity.TypeEtablissement;
import com.projetfinal.etablissement.entity.TypeUtilisateur;
import com.projetfinal.etablissement.entity.Utilisateur;
import com.projetfinal.etablissement.repository.EtablissementRepo;
import com.projetfinal.etablissement.repository.UtilisateurRepo;

@Service
public class ConsoleService implements CommandLineRunner {

	@Autowired
	private EtablissementService etablissementService;
	@Autowired
	private UtilisateurService utilisateurService;


	@Override
	public void run(String... args) throws Exception {
		

		Adresse adresse1 = new Adresse("Rue Rouge", 1, "06000", "Nice");
		Adresse adresse2 = new Adresse("Rue vert", 1, "06000", "Nice");
		Adresse adresse3 = new Adresse("Rue bleu", 1, "06000", "Nice");
		Etablissement etablissement1 = new Etablissement("College", adresse1, TypeEtablissement.COLLEGE, "0600000001", "logo");
		etablissement1 = etablissementService.save(etablissement1);
		Etablissement etablissement2 = new Etablissement("Lycee", adresse2, TypeEtablissement.LYCEE, "0600000002", "logo");
		etablissement2 = etablissementService.save(etablissement2);
		Etablissement etablissement3 = new Etablissement("Ecole", adresse3, TypeEtablissement.ECOLE, "0600000003", "logo");
		etablissement3 = etablissementService.save(etablissement3);
		
		
		
		Login login = new Login("hajars","hajar1",TypeUtilisateur.UTILISATEUR);
		//login.setPassword(passwordEncoder.encode(login.getPassword()));
		
		//Professeur(@NotNull Login login, @NotEmpty String nom, @NotEmpty String prenom, @NotNull Adresse adresse,
		//		@NotNull LocalDate dateNaissance, @NotNull Etablissement etablissement, @NotEmpty Cours cours);

		
		Adresse adresse4 = new Adresse("Rue violet", 2, "06000", "Nice");
		LocalDate dateNaissance = LocalDate.of(1968, Month.JANUARY, 1);
		Login login1 = new Login("admin", "pass", TypeUtilisateur.ADMIN);
		Utilisateur utilisateur1 = new Utilisateur(login1, "admin", "admin", adresse4, dateNaissance, etablissement1);
		utilisateurService.save(utilisateur1);
		Login login2 = new Login("user", "pass", TypeUtilisateur.UTILISATEUR);
		Utilisateur utilisateur2 = new Utilisateur(login2, "user", "user", adresse4, dateNaissance, etablissement2);
		utilisateurService.save(utilisateur2);
		
		Login login3 = new Login("TestPass", TypeUtilisateur.UTILISATEUR);
		Utilisateur testUserGeneratePassword = new Utilisateur(login3, "userTestPass", "userTestPass", adresse4, dateNaissance, etablissement2);
		System.out.println("\n\n\n Password temp = " + login3.getPassword());
		utilisateurService.save(testUserGeneratePassword);
		
	}

}

package com.projetfinal.etablissement.service;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.projetfinal.etablissement.entity.Adresse;
import com.projetfinal.etablissement.entity.Etablissement;
import com.projetfinal.etablissement.entity.Login;
import com.projetfinal.etablissement.entity.TypeEtablissement;
import com.projetfinal.etablissement.entity.TypeUtilisateur;
import com.projetfinal.etablissement.entity.Utilisateur;
import com.projetfinal.etablissement.repository.EtablissementRepo;
import com.projetfinal.etablissement.repository.UtilisateurRepo;

@Service
public class ConsoleService implements CommandLineRunner {

	@Autowired
	private EtablissementRepo etablissementRepo;
	@Autowired
	private UtilisateurRepo utilisateurRepo;
	
	


	@Override
	public void run(String... args) throws Exception {
		
		Adresse adresse1 = new Adresse("nomRue", 1, "06333", "ville");
		//adresse1 = adresseRepo.save(adresse1);
		Etablissement etablissement1 = new Etablissement("etablissement1", adresse1, TypeEtablissement.COLLEGE, "0666666666", "logo");
		etablissementRepo.save(etablissement1);
		
//		Adresse adresse2 = new Adresse("nomRue", 2, "06333", "ville");
//		adresse2 = adresseRepo.save(adresse2);
//		LocalDate dateNaissance = LocalDate.of(2014, Month.JANUARY, 1);
//		Login login1 = new Login("login", "pass", TypeUtilisateur.ADMIN);
//		login1 = loginRepo.save(login1);
//		Utilisateur utilisateur1 = new Utilisateur(login1, "nom1", "prenom1", adresse2, dateNaissance, etablissement1);
//		utilisateurRepo.save(utilisateur1);
		
	}

}

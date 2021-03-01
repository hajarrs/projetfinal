package com.projetfinal.etablissement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.projetfinal.etablissement.entity.Utilisateur;
import com.projetfinal.etablissement.repository.UtilisateurRepo;

@Service
public class UtilisateurService {
	@Autowired
	private UtilisateurRepo utilisateurRepo;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	// definir tous les traitements disponible sur l'entite utilisateur

	public void creationUtilisateur(Utilisateur p) {
		if (p.getPrenom() != null && !p.getPrenom().isEmpty() && p.getNom() != null && !p.getNom().isEmpty()
				&& p.getEtablissement() != null) {
			utilisateurRepo.save(p);
		} else {
			System.out.println("le utilisateur n'a pas toute les infos obligatoires");
		}
	}

//		public void creationUtilisateur(String prenom, String nom) {
//			creationUtilisateur(new Utilisateur(prenom, nom));
//		}

	public List<Utilisateur> allUtilisateur() {
		return utilisateurRepo.findAll();
	}

	public void delete(Utilisateur u) {
		utilisateurRepo.delete(u);
	}

	public void delete(Integer id) {
		utilisateurRepo.deleteById(id);
	}

	public Utilisateur save(Utilisateur u) {
		u.getLogin().setPassword(passwordEncoder.encode(u.getLogin().getPassword()));
		return utilisateurRepo.save(u);
	}

	public Utilisateur find(Integer id) {
		Optional<Utilisateur> opt = utilisateurRepo.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}
		return new Utilisateur();
	}

}

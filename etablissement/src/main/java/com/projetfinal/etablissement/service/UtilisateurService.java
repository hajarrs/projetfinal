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

	public Utilisateur creationUtilisateur(Utilisateur p) {
		if (p.getPrenom() != null && !p.getPrenom().isEmpty() && p.getNom() != null && !p.getNom().isEmpty()
				&& p.getEtablissement() != null) {
			if (p.getLogin().getPassword()!= null) {
				p.getLogin().setPassword(passwordEncoder.encode(p.getLogin().getPassword()));
			} else {
				p.getLogin().setPassword(passwordEncoder.encode(p.getLogin().generatePassword()));
			}
			return utilisateurRepo.save(p);
		} else {
			System.out.println("le utilisateur n'a pas toute les infos obligatoires");
			return p;
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
		return utilisateurRepo.save(u);
	}

	public Utilisateur find(Integer id) {
		Optional<Utilisateur> opt = utilisateurRepo.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}
		return new Utilisateur();
	}
	
	public Utilisateur findByLogin(String login) {
		Optional<Utilisateur> opt = utilisateurRepo.findByLogin(login);
		if (opt.isPresent()) {
			return opt.get();
		}
		return new Utilisateur();
	}

}

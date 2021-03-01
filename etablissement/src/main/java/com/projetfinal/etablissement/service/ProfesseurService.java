package com.projetfinal.etablissement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetfinal.etablissement.entity.Professeur;
import com.projetfinal.etablissement.repository.ProfesseurRepo;

@Service
public class ProfesseurService {
	@Autowired
	private ProfesseurRepo professeurRepo;

	// definir tous les traitements disponible sur l'entite professeur

	public void creationProfesseur(Professeur p) {
		if (p.getPrenom() != null && !p.getPrenom().isEmpty() && p.getNom() != null && !p.getNom().isEmpty()
				&& p.getEtablissement() != null && p.getMatieres() != null && !p.getMatieres().isEmpty()) {
			professeurRepo.save(p);
		} else {
			System.out.println("le professeur n'a pas toute les infos obligatoires");
		}
	}

//		public void creationProfesseur(String prenom, String nom) {
//			creationProfesseur(new Professeur(prenom, nom));
//		}

	public List<Professeur> allProfesseur() {
		return professeurRepo.findAll();
	}

	public void delete(Professeur p) {
		professeurRepo.delete(p);
	}

	public void delete(Integer id) {
		professeurRepo.deleteById(id);
	}

	public Professeur save(Professeur p) {
		return professeurRepo.save(p);
	}

	public Professeur find(Integer id) {
		Optional<Professeur> opt = professeurRepo.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}
		return new Professeur();
	}

}

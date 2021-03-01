package com.projetfinal.etablissement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetfinal.etablissement.entity.Matiere;
import com.projetfinal.etablissement.repository.MatiereRepo;

@Service
public class MatiereService {
	@Autowired
	private MatiereRepo matiereRepo;

// definir tous les traitements disponible sur l'entite Matiere

	public void creationMatiere(Matiere m) {
		if (m.getNom() != null && !m.getNom().isEmpty() && m.getCouleur() != null && !m.getCouleur().isEmpty()) {
			matiereRepo.save(m);
		} else {
			System.out.println("la matière n'a pas toute les infos obligatoires");
		}
	}

//	public void creationMatiere(String prenom, String nom) {
//		creationProfesseur(new Professeur(prenom, nom));
//	}

	public List<Matiere> allMatiere() {
		return matiereRepo.findAll();
	}

	public void delete(Matiere m) {
		matiereRepo.delete(m);
	}

	public void delete(Integer id) {
		matiereRepo.deleteById(id);
	}

	public Matiere save(Matiere p) {
		return matiereRepo.save(p);
	}

	public Matiere find(Integer id) {
		Optional<Matiere> opt = matiereRepo.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}
		return new Matiere();
	}

}
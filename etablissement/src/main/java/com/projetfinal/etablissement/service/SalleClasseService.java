package com.projetfinal.etablissement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetfinal.etablissement.entity.SalleClasse;
import com.projetfinal.etablissement.repository.SalleClasseRepo;

@Service
public class SalleClasseService {
	@Autowired
	private SalleClasseRepo salleClasseRepo;

	// definir tous les traitements disponible sur l'entite SalleClasse

	public void creationSalleClasse(SalleClasse sc) {
		if (sc.getNom() != null && !sc.getNom().isEmpty()) {
			salleClasseRepo.save(sc);
		} else {
			System.out.println("la salle de classe n'a pas toute les infos obligatoires");
		}
	}

//	public void creationSalleClasse(String prenom, String nom) {
//		creationProfesseur(new Professeur(prenom, nom));
//	}

	public List<SalleClasse> allSalleClasse() {
		return salleClasseRepo.findAll();
	}

	public void delete(SalleClasse sc) {
		salleClasseRepo.delete(sc);
	}

	public void delete(Integer id) {
		salleClasseRepo.deleteById(id);
	}

	public SalleClasse save(SalleClasse sc) {
		return salleClasseRepo.save(sc);
	}

	public SalleClasse find(Integer id) {
		Optional<SalleClasse> opt = salleClasseRepo.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}
		return new SalleClasse();
	}

}
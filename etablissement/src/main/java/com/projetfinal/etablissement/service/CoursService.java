package com.projetfinal.etablissement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetfinal.etablissement.entity.Cours;
import com.projetfinal.etablissement.repository.CoursRepo;

@Service
public class CoursService {
	@Autowired
	private CoursRepo coursRepo;
//
//	// definir tous les traitements disponible sur l'entite Cours
//
	public void creationCours(Cours c) {
		if (c.getSalle() == null || c.getDateHeureDebut() == null || c.getDateHeureFin() == null || c.getMatiere() == null || c.getProfesseur() == null) {
			System.out.println("le cours n'a pas toute les infos obligatoires");			
		} else {
			coursRepo.save(c);
		}
	}

//	public void creationCours() {
//		creationCours(new Cours(String truc, String machin));
//	}

	public List<Cours> allCours() {
		return coursRepo.findAll();
	}

	public void delete(Cours c) {
		coursRepo.delete(c);
	}

	public void delete(Integer id) {
		coursRepo.deleteById(id);
	}

	public Cours save(Cours c) {
		return coursRepo.save(c);
	}

	public Cours find(Integer id) {
		Optional<Cours> opt = coursRepo.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}
		return new Cours();
	}

}
package com.projetfinal.etablissement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetfinal.etablissement.entity.Etablissement;
import com.projetfinal.etablissement.repository.EtablissementRepo;

@Service
public class EtablissementService {
	@Autowired
	private EtablissementRepo etablissementRepo;

	// definir tous les traitements disponible sur l'entite Etablissement

	public void creationEtablissement(Etablissement e) {
		if (e.getAdresse() != null && e.getNom() != null && !e.getNom().isEmpty() && e.getTypeEtablissement() != null) {
			etablissementRepo.save(e);
		} else {
			System.out.println("l'établissement n'a pas toute les infos obligatoires");
		}
	}

//	public void creationEtablissement(String prenom, String nom) {
//		creationProfesseur(new Professeur(prenom, nom));
//	}

	public List<Etablissement> allEtablissement() {
		return etablissementRepo.findAll();
	}

	public void delete(Etablissement e) {
		etablissementRepo.delete(e);
	}

	public void delete(Integer id) {
		etablissementRepo.deleteById(id);
	}

	public Etablissement save(Etablissement e) {
		return etablissementRepo.save(e);
	}

	public Etablissement find(Integer id) {
		Optional<Etablissement> opt = etablissementRepo.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}
		return new Etablissement();
	}

}
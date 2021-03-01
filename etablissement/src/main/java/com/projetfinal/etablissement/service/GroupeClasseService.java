package com.projetfinal.etablissement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetfinal.etablissement.entity.GroupeClasse;
import com.projetfinal.etablissement.repository.GroupeClasseRepo;

@Service
public class GroupeClasseService {
	@Autowired
	private GroupeClasseRepo classeRepo;

	// definir tous les traitements disponible sur l'entite GroupeClasse

	public void creationGroupeClasse(GroupeClasse gc) {
		if (gc.getNom() != null && !gc.getNom().isEmpty() && gc.getProfesseurPrincipal() != null) {
			classeRepo.save(gc);
		} else {
			System.out.println("le groupeClasse n'a pas toute les infos obligatoires");
		}
	}

//	public void creationGroupe(String prenom, String nom) {
//		creationProfesseur(new Professeur(prenom, nom));
//	}

	public List<GroupeClasse> allGroupeClasse() {
		return classeRepo.findAll();
	}

	public void delete(GroupeClasse gc) {
		classeRepo.delete(gc);
	}

	public void delete(Integer id) {
		classeRepo.deleteById(id);
	}

	public GroupeClasse save(GroupeClasse gc) {
		return classeRepo.save(gc);
	}

	public GroupeClasse find(Integer id) {
		Optional<GroupeClasse> opt = classeRepo.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}
		return new GroupeClasse();
	}

}
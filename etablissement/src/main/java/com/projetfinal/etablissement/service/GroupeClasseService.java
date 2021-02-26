package com.projetfinal.etablissement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.projetfinal.etablissement.entity.GroupeClasse;

@Service
public class GroupeClasseService {
//	@Autowired
//	private RepositoryProfesseur professeurRepo;
//
//	// definir tous les traitements disponible sur l'entite Groupe
//
	public void creationProfesseur(GroupeClasse p) {
//		if (p.getPrenom() != null && !p.getPrenom().isEmpty() && p.getNom() != null && !p.getNom().isEmpty()) {
//			personneRepo.save(p);
//		} else {
//			System.out.println("la personne n'a pas toute les infos obligatoires");
//		}
	}

	public void creationGroupe(String prenom, String nom) {
//		creationProfesseur(new Professeur(prenom, nom));
	}

	public List<GroupeClasse> allGroupeClasse() {
//		return personneRepo.findAll();
		return null;
	}

	public void delete(GroupeClasse p) {
//		personneRepo.delete(p);
	}

	public void delete(Integer id) {
//		personneRepo.deleteById(id);
	}

	public GroupeClasse save(GroupeClasse p) {
//		return personneRepo.save(p);
		return null;
	}

	public GroupeClasse find(Integer id) {
//		Optional<Professeur> opt = personneRepo.findById(id);
//		if (opt.isPresent()) {
//			return opt.get();
//		}
//		return new Personne();
		return null;
	}

}
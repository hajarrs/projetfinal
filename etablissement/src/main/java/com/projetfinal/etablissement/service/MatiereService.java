package com.projetfinal.etablissement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.projetfinal.etablissement.entity.Matiere;

@Service
public class MatiereService {
//	@Autowired
//	private RepositoryProfesseur professeurRepo;
//
//	// definir tous les traitements disponible sur l'entite Matiere
//
	public void creationProfesseur(Matiere p) {
//		if (p.getPrenom() != null && !p.getPrenom().isEmpty() && p.getNom() != null && !p.getNom().isEmpty()) {
//			personneRepo.save(p);
//		} else {
//			System.out.println("la personne n'a pas toute les infos obligatoires");
//		}
	}

	public void creationMatiere(String prenom, String nom) {
//		creationProfesseur(new Professeur(prenom, nom));
	}

	public List<Matiere> allMatiere() {
//		return personneRepo.findAll();
		return null;
	}

	public void delete(Matiere p) {
//		personneRepo.delete(p);
	}

	public void delete(Integer id) {
//		personneRepo.deleteById(id);
	}

	public Matiere save(Matiere p) {
//		return personneRepo.save(p);
		return null;
	}

	public Matiere find(Integer id) {
//		Optional<Professeur> opt = personneRepo.findById(id);
//		if (opt.isPresent()) {
//			return opt.get();
//		}
//		return new Personne();
		return null;
	}

}
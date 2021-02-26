package com.projetfinal.etablissement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.projetfinal.etablissement.entity.Cours;

@Service
public class CoursService {
//	@Autowired
//	private RepositoryProfesseur professeurRepo;
//
//	// definir tous les traitements disponible sur l'entite Cours
//
	public void creationProfesseur(Cours p) {
//		if (p.getPrenom() != null && !p.getPrenom().isEmpty() && p.getNom() != null && !p.getNom().isEmpty()) {
//			personneRepo.save(p);
//		} else {
//			System.out.println("la personne n'a pas toute les infos obligatoires");
//		}
	}

	public void creationCours(String prenom, String nom) {
//		creationProfesseur(new Professeur(prenom, nom));
	}

	public List<Cours> allCours() {
//		return personneRepo.findAll();
		return null;
	}

	public void delete(Cours p) {
//		personneRepo.delete(p);
	}

	public void delete(Integer id) {
//		personneRepo.deleteById(id);
	}

	public Cours save(Cours p) {
//		return personneRepo.save(p);
		return null;
	}

	public Cours find(Integer id) {
//		Optional<Professeur> opt = personneRepo.findById(id);
//		if (opt.isPresent()) {
//			return opt.get();
//		}
//		return new Personne();
		return null;
	}

}
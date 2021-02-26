package com.projetfinal.etablissement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.projetfinal.etablissement.entity.SalleClasse;

@Service
public class SalleClasseService {
//	@Autowired
//	private RepositoryProfesseur professeurRepo;
//
//	// definir tous les traitements disponible sur l'entite Salle
//
	public void creationProfesseur(SalleClasse p) {
//		if (p.getPrenom() != null && !p.getPrenom().isEmpty() && p.getNom() != null && !p.getNom().isEmpty()) {
//			personneRepo.save(p);
//		} else {
//			System.out.println("la personne n'a pas toute les infos obligatoires");
//		}
	}

	public void creationSalleClasse(String prenom, String nom) {
//		creationProfesseur(new Professeur(prenom, nom));
	}

	public List<SalleClasse> allSalleClasse() {
//		return personneRepo.findAll();
		return null;
	}

	public void delete(SalleClasse p) {
//		personneRepo.delete(p);
	}

	public void delete(Integer id) {
//		personneRepo.deleteById(id);
	}

	public SalleClasse save(SalleClasse p) {
//		return personneRepo.save(p);
		return null;
	}

	public SalleClasse find(Integer id) {
//		Optional<Professeur> opt = personneRepo.findById(id);
//		if (opt.isPresent()) {
//			return opt.get();
//		}
//		return new Personne();
		return null;
	}

}
package com.projetfinal.etablissement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.projetfinal.etablissement.entity.Etablissement;

@Service
public class EtablissementService {
//	@Autowired
//	private RepositoryEtablissement professeurRepo;
//
//	// definir tous les traitements disponible sur l'entite Etablissement
//
	public void creationEtablissement(Etablissement p) {
//		if (p.getPrenom() != null && !p.getPrenom().isEmpty() && p.getNom() != null && !p.getNom().isEmpty()) {
//			personneRepo.save(p);
//		} else {
//			System.out.println("la personne n'a pas toute les infos obligatoires");
//		}
	}

	public void creationEtablissement(String prenom, String nom) {
//		creationProfesseur(new Professeur(prenom, nom));
	}

	public List<Etablissement> allEtablissement() {
//		return personneRepo.findAll();
		return null;
	}

	public void delete(Etablissement p) {
//		personneRepo.delete(p);
	}

	public void delete(Integer id) {
//		personneRepo.deleteById(id);
	}

	public Etablissement save(Etablissement p) {
//		return personneRepo.save(p);
		return null;
	}

	public Etablissement find(Integer id) {
//		Optional<Professeur> opt = personneRepo.findById(id);
//		if (opt.isPresent()) {
//			return opt.get();
//		}
//		return new Personne();
		return null;
	}

}
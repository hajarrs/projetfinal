package com.projetfinal.etablissement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.projetfinal.etablissement.entity.Professeur;

@Service
public class ProfesseurService {
//		@Autowired
//		private RepositoryProfesseur professeurRepo;
//
//		// definir tous les traitements disponible sur l'entite professeur
//
		public void creationProfesseur(Professeur p) {
//			if (p.getPrenom() != null && !p.getPrenom().isEmpty() && p.getNom() != null && !p.getNom().isEmpty()) {
//				personneRepo.save(p);
//			} else {
//				System.out.println("la personne n'a pas toute les infos obligatoires");
//			}
		}

		public void creationProfesseur(String prenom, String nom) {
//			creationProfesseur(new Professeur(prenom, nom));
		}

		public List<Professeur> allProfesseur() {
//			return personneRepo.findAll();
			return null;
		}

		public void delete(Professeur p) {
//			personneRepo.delete(p);
		}

		public void delete(Integer id) {
//			personneRepo.deleteById(id);
		}

		public Professeur save(Professeur p) {
//			return personneRepo.save(p);
			return null;
		}

		public Professeur find(Integer id) {
//			Optional<Professeur> opt = personneRepo.findById(id);
//			if (opt.isPresent()) {
//				return opt.get();
//			}
//			return new Personne();
			return null;
		}

	}

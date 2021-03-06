package com.projetfinal.etablissement.service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetfinal.etablissement.entity.Cours;
import com.projetfinal.etablissement.entity.Matiere;
import com.projetfinal.etablissement.entity.SalleClasse;
import com.projetfinal.etablissement.repository.CoursRepo;

@Service
public class CoursService {
	@Autowired
	private CoursRepo coursRepo;
//
//	// definir tous les traitements disponible sur l'entite Cours
//
	/**
	 * 
	 * @param c le Cours à créer
 	 * @return le cours en cas de succès, null sinon
	 */
	public Cours creationCours(Cours c) {
		if (c.getSalle() == null || c.getHeureDebut() == null || c.getHeureFin() == null 
				|| c.getMatiere() == null || c.getProfesseur() == null) {
			System.out.println("le cours n'a pas toute les infos obligatoires");
			return null;
		} else {
			return coursRepo.save(c);
		}
	}

//	public void creationCours() {
//		creationCours(new Cours(String truc, String machin));
//	}

	public List<Cours> allCours() {
		return coursRepo.findAll();
	}

	public List<Cours> findByProf(Integer id) {
		return coursRepo.findAllForProfesseur(id);
	}

	public List<Cours> findBySalle(Integer id) {
		return coursRepo.findAllForSalle(id);
	}
	public List<Cours> findByMatiere(Integer id) {
		return coursRepo.findAllForMatiere(id);
	}
	
	public void delete(Cours c) {
		coursRepo.delete(c);
	}

	public void delete(Integer id) {
		coursRepo.deleteById(id);
	}

	/**
	 * 
	 * @param c Cours à ajouter
	 * @return le cours en cas de succès, null sinon
	 */
	public Cours save(Cours c) {
		if (ajoutOK(c)) {
			return coursRepo.save(c);			
		} else {
			System.out.println("Cours non sauvé : " + c.getProfesseur().getNom() + " jour " + c.getDay() + " debut " + c.getHeureDebut());
			return null;
		}
	}

	public Cours find(Integer id) {
		Optional<Cours> opt = coursRepo.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}
		return new Cours();
	}

	/**
	 * 
	 * @param c Cours to check
	 * @return true si le cours est possible (disponibilité professeur sur le créneau,disponibilité salle , cours autorisé dans cette salle) 
	 */
	private boolean ajoutOK(Cours c) {
		if (c == null
				|| c.getHeureDebut() == null
				|| c.getHeureFin() == null
				|| c.getMatiere() == null
				|| c.getProfesseur() == null
				|| c.getProfesseur().getMatieres() == null
				|| c.getSalle() == null) {
			System.out.println("CoursService ajoutKO: manque infos");
			return false;
		} else {
			SalleClasse salleClasse = c.getSalle();
			Matiere matiere = c.getMatiere();
			
			// vérifie si la salle permet d'enseigner cette matière
			if (salleClasse.getMatieresExclues() != null && salleClasse.getMatieresExclues().contains(matiere)) {
				System.out.println("CoursService ajoutKO: matière interdite dans la salle");
				return false;
			}

			// vérifie si le prof enseigne cette matière
			if (!c.getProfesseur().getMatieres().contains(c.getMatiere())) {
				System.out.println("CoursService ajoutKO: matière non enseignée par le prof");
				return false;				
			}
			
			// vérifier qu'il n'y a pas de chevauchements de cours dans la même salle ou de prof déjà occupé
			for (Cours c2 : allCours()) {

				if (chevauchementHoraire(c, c2)) {
					// verif salle
					if (c.getSalle() != null
							&& c2.getSalle() != null
							&& c.getSalle().equals(c2.getSalle())) {

						System.out.println("CoursService ajoutKO: salle déjà occupée");
						// salle déjà occupée 
						return false;
					}
					
					// verif prof
					if (c.getProfesseur() != null
							&& c2.getProfesseur() != null
							&& c.getProfesseur().equals(c2.getProfesseur())) {
						
						System.out.println("CoursService ajoutKO: prof déjà occupé");
						// prof déjà occupé
						return false;
					}
				}
			}
		}
		return true;
	}
	
	/**
	 * 
	 * @param c1
	 * @param c2
	 * @return true si c1 a un chevauchement horaire avec c2 (sur le même jour)
	 */
	private boolean chevauchementHoraire(Cours c1, Cours c2) {
		if (c1 != null
				&& c2 != null
				&& c1.getDay() == c2.getDay()
				&& c1.getHeureDebut() != null
				&& c2.getHeureDebut() != null
				&& c1.getHeureFin() != null
				&& c2.getHeureFin() != null) {
			int c1Debut = getHoraireEnMinutes(c1.getHeureDebut());
			int c1Fin = getHoraireEnMinutes(c1.getHeureFin());
			int c2Debut = getHoraireEnMinutes(c2.getHeureDebut());
			int c2Fin = getHoraireEnMinutes(c2.getHeureFin());
			
			if ((c1Debut >= c2Debut && c1Debut < c2Fin)
					|| (c2Debut >= c1Debut && c2Debut < c1Fin)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param horaire
	 * @return l'horaire en nombre de minute, en ne prenant en compte que les heures et les minutes de horaire
	 */
	private int getHoraireEnMinutes(LocalTime horaire) {
		int result = 0;
		if (horaire != null) {
			result += (horaire.getHour() * 60);
			result += horaire.getMinute();
		}
		return result;
	}
	
	
	
	

}
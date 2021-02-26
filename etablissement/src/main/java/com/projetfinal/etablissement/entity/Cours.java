package com.projetfinal.etablissement.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Cours {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private LocalDateTime dateHeureDebut;
	private LocalDateTime dateHeureFin;
	@OneToOne
	private Professeur professeur;
	@OneToOne
	private Matiere matiere;
	@OneToOne
	private SalleClasse salle;
	
	public Cours() {
	}

	public Integer getId() {
		return id;
	}

	public LocalDateTime getDateHeureDebut() {
		return dateHeureDebut;
	}

	public void setDateHeureDebut(LocalDateTime dateHeureDebut) {
		this.dateHeureDebut = dateHeureDebut;
	}

	public LocalDateTime getDateHeureFin() {
		return dateHeureFin;
	}

	public void setDateHeureFin(LocalDateTime dateHeureFin) {
		this.dateHeureFin = dateHeureFin;
	}

	public Professeur getProfesseur() {
		return professeur;
	}

	public void setProfesseur(Professeur professeur) {
		this.professeur = professeur;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public SalleClasse getSalle() {
		return salle;
	}

	public void setSalle(SalleClasse salle) {
		this.salle = salle;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cours other = (Cours) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}

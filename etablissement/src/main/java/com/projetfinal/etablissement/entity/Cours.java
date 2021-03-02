package com.projetfinal.etablissement.entity;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Cours {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonView(Vue.Common.class)
	private Integer id;
	@JsonView(Vue.Common.class)
	private LocalTime heureDebut;
	@JsonView(Vue.Common.class)
	private LocalTime heureFin;
	@JsonView(Vue.Common.class)
	private int day; // 0 à 6, pour être utilisé avec les méthodes de java.util.Date.getDay()
	@ManyToOne
	@JsonView(Vue.Common.class)
	private Professeur professeur;
	@ManyToOne
	@JsonView(Vue.Common.class)
	private Matiere matiere;
	@ManyToOne
	@JsonView(Vue.Common.class)
	private SalleClasse salle;
	
	public Cours() {
	}

	public Cours(LocalTime heureDebut, LocalTime heureFin, Professeur professeur, Matiere matiere,
			SalleClasse salle, int day) {
		super();
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
		this.professeur = professeur;
		this.matiere = matiere;
		this.salle = salle;
		this.day = day;
	}

	public Integer getId() {
		return id;
	}

	public LocalTime getHeureDebut() {
		return heureDebut;
	}

	public void setHeureDebut(LocalTime heureDebut) {
		this.heureDebut = heureDebut;
	}

	public LocalTime getHeureFin() {
		return heureFin;
	}

	public void setHeureFin(LocalTime heureFin) {
		this.heureFin = heureFin;
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

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}
	
	
}

package com.projetfinal.etablissement.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Matiere {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String nom;
	private String couleur;
//	@OneToOne
//	private Cours cours;
	@ManyToMany
	private List<Professeur> professeurs;
	@ManyToMany
	private List<SalleClasse> salles;
	
	public Matiere() {
	}
	

	public Matiere(String nom, String couleur) {
		super();
		this.nom = nom;
		this.couleur = couleur;
	}


	public Integer getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

//	public Cours getCours() {
//		return cours;
//	}
//
//	public void setCours(Cours cours) {
//		this.cours = cours;
//	}

	public List<Professeur> getProfesseurs() {
		return professeurs;
	}

	public void setProfesseurs(List<Professeur> professeurs) {
		this.professeurs = professeurs;
	}

	public List<SalleClasse> getSalles() {
		return salles;
	}

	public void setSalles(List<SalleClasse> salles) {
		this.salles = salles;
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
		Matiere other = (Matiere) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}

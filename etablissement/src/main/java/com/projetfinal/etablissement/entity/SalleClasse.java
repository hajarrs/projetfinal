package com.projetfinal.etablissement.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity
public class SalleClasse {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String nom;
	@ManyToMany(mappedBy = "salles")
    private List<Matiere> matieresExclues;
	private Integer capacite;
//	@OneToOne
//	private Cours cours;
	@Version
	private int version;
	
	public SalleClasse() {
	}

	public SalleClasse(String nom, Integer capacite) {
		this.nom = nom;
		this.capacite = capacite;
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

	public List<Matiere> getMatieresExclues() {
		return matieresExclues;
	}

	public void setMatieresExclues(List<Matiere> matieresExclues) {
		this.matieresExclues = matieresExclues;
	}

	public Integer getCapacite() {
		return capacite;
	}

	public void setCapacite(Integer capacite) {
		this.capacite = capacite;
	}

//	public Cours getCours() {
//		return cours;
//	}
//
//	public void setCours(Cours cours) {
//		this.cours = cours;
//	}

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
		SalleClasse other = (SalleClasse) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}

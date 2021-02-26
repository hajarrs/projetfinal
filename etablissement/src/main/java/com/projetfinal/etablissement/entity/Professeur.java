package com.projetfinal.etablissement.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Professeur extends Utilisateur{
	
	@ManyToMany
	private List<Matiere> matieres;
//	@OneToOne
//	private Cours cours;
//	@OneToMany
//	private List<GroupeClasse> groupes;
	public Professeur() {
	}

	public List<Matiere> getMatieres() {
		return matieres;
	}

	public void setMatieres(List<Matiere> matieres) {
		this.matieres = matieres;
	}

//	public Cours getCours() {
//		return cours;
//	}
//
//	public void setCours(Cours cours) {
//		this.cours = cours;
//	}
//
//	public List<GroupeClasse> getGroupes() {
//		return groupes;
//	}
//
//	public void setGroupes(List<GroupeClasse> groupes) {
//		this.groupes = groupes;
//	}
	
}

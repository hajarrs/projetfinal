package com.projetfinal.etablissement.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Professeur extends Utilisateur{
	
	
	@ManyToMany//(mappedBy = "professeurs")
	@JsonView(Vue.Common.class)
	private List<Matiere> matieres;
//	@OneToOne
//	private Cours cours;
	@OneToMany(mappedBy = "professeurPrincipal")
	@JsonView(Vue.Common.class)
	private List<GroupeClasse> groupes;
	
	public Professeur() {
	}

	public Professeur(@NotNull Login login, @NotEmpty String nom, @NotEmpty String prenom, @NotNull Adresse adresse,
			@NotNull LocalDate dateNaissance, @NotNull Etablissement etablissement) {
		super(login,nom,prenom,adresse,dateNaissance,etablissement);
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

	public List<GroupeClasse> getGroupes() {
		return groupes;
	}

	public void setGroupes(List<GroupeClasse> groupes) {
		this.groupes = groupes;
	}
	
}

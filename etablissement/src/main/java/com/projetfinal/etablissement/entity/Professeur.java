package com.projetfinal.etablissement.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Professeur extends Utilisateur{
	
	
	@ManyToMany(mappedBy = "professeurs")
	private List<Matiere> matieres;
	@OneToOne
	private Cours cours;
	@OneToMany(mappedBy = "professeurPrincipal")
	private List<GroupeClasse> groupes;
	
	public Professeur() {
	}

	public Professeur(@NotNull Login login, @NotEmpty String nom, @NotEmpty String prenom, @NotNull Adresse adresse,
			@NotNull LocalDate dateNaissance, @NotNull Etablissement etablissement, @NotEmpty Cours cours) {
		super(login,nom,prenom,adresse,dateNaissance,etablissement);
		this.cours = cours;
	}

	public List<Matiere> getMatieres() {
		return matieres;
	}

	public void setMatieres(List<Matiere> matieres) {
		this.matieres = matieres;
	}

	public Cours getCours() {
		return cours;
	}

	public void setCours(Cours cours) {
		this.cours = cours;
	}

	public List<GroupeClasse> getGroupes() {
		return groupes;
	}

	public void setGroupes(List<GroupeClasse> groupes) {
		this.groupes = groupes;
	}
	
}

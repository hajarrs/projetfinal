package com.projetfinal.etablissement.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "Goupe")
public class GroupeClasse {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonView(Vue.Common.class)
	private Integer id;
	@JsonView(Vue.Common.class)
	private String nom;
	@ManyToOne
	@JsonView(Vue.CommonGroupeWithProfesseurPrincipal.class)
	private Professeur professeurPrincipal;
	
	public GroupeClasse() {
	}
	
	public GroupeClasse(String nom, Professeur professeurPrincipal) {
		this.nom = nom;
		this.professeurPrincipal = professeurPrincipal;
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
	public Professeur getProfesseurPrincipal() {
		return professeurPrincipal;
	}
	public void setProfesseurPrincipal(Professeur professeurPrincipal) {
		this.professeurPrincipal = professeurPrincipal;
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
		GroupeClasse other = (GroupeClasse) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}

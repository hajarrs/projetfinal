package com.projetfinal.etablissement.entity;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonView;

@Embeddable
public class Adresse {

	@NotEmpty
	@JsonView(Vue.Common.class)
	private String nomRue;
	@NotEmpty
	@JsonView(Vue.Common.class)
	private Integer numRue;
	@NotEmpty
	@JsonView(Vue.Common.class)
	private String codePostal;
	@NotEmpty
	@JsonView(Vue.Common.class)
	private String ville;
	
	
	public Adresse() {
	}

	public Adresse(@NotEmpty String nomRue, @NotEmpty Integer numRue, @NotEmpty String codePostal,
			@NotEmpty String ville) {
		this.nomRue = nomRue;
		this.numRue = numRue;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	public String getNomRue() {
		return nomRue;
	}

	public void setNomRue(String nomRue) {
		this.nomRue = nomRue;
	}

	public Integer getNumRue() {
		return numRue;
	}

	public void setNumRue(Integer numRue) {
		this.numRue = numRue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codePostal == null) ? 0 : codePostal.hashCode());
		result = prime * result + ((nomRue == null) ? 0 : nomRue.hashCode());
		result = prime * result + ((numRue == null) ? 0 : numRue.hashCode());
		result = prime * result + ((ville == null) ? 0 : ville.hashCode());
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
		Adresse other = (Adresse) obj;
		if (codePostal == null) {
			if (other.codePostal != null)
				return false;
		} else if (!codePostal.equals(other.codePostal))
			return false;
		if (nomRue == null) {
			if (other.nomRue != null)
				return false;
		} else if (!nomRue.equals(other.nomRue))
			return false;
		if (numRue == null) {
			if (other.numRue != null)
				return false;
		} else if (!numRue.equals(other.numRue))
			return false;
		if (ville == null) {
			if (other.ville != null)
				return false;
		} else if (!ville.equals(other.ville))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Adresse [nomRue=" + nomRue + ", numRue=" + numRue + ", codePostal=" + codePostal + ", ville=" + ville
				+ "]";
	}
	
	
}

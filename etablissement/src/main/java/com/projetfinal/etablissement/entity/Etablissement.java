package com.projetfinal.etablissement.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@SequenceGenerator(name = "seqEtablissement", sequenceName = "seq_etablissement", initialValue = 10, allocationSize = 1)
public class Etablissement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqEtablissement")
	@JsonView(Vue.Common.class)
	private Integer id;
	
	@NotEmpty
	@JsonView(Vue.Common.class)
	private String nom;
	@NotNull
	@Embedded
	@JsonView(Vue.Common.class)
	private Adresse adresse;
	@NotNull
	@Enumerated(EnumType.STRING)
	@JsonView(Vue.Common.class)
	private TypeEtablissement typeEtablissement;
	@NotEmpty
	@JsonView(Vue.Common.class)
	private String numTel;
	private String logo;
	@Version
	private int version;
	
	
	public Etablissement() {
	}


	public Etablissement(@NotEmpty String nom, @NotNull Adresse adresse, @NotNull TypeEtablissement typeEtablissement,
			@NotEmpty String numTel, String logo) {
		this.nom = nom;
		this.adresse = adresse;
		this.typeEtablissement = typeEtablissement;
		this.numTel = numTel;
		this.logo = logo;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public Adresse getAdresse() {
		return adresse;
	}


	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}


	public TypeEtablissement getTypeEtablissement() {
		return typeEtablissement;
	}


	public void setTypeEtablissement(TypeEtablissement typeEtablissement) {
		this.typeEtablissement = typeEtablissement;
	}


	public String getNumTel() {
		return numTel;
	}


	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}


	public String getLogo() {
		return logo;
	}


	public void setLogo(String logo) {
		this.logo = logo;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((logo == null) ? 0 : logo.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((numTel == null) ? 0 : numTel.hashCode());
		result = prime * result + ((typeEtablissement == null) ? 0 : typeEtablissement.hashCode());
		result = prime * result + version;
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
		Etablissement other = (Etablissement) obj;
		if (adresse == null) {
			if (other.adresse != null)
				return false;
		} else if (!adresse.equals(other.adresse))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (logo == null) {
			if (other.logo != null)
				return false;
		} else if (!logo.equals(other.logo))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (numTel == null) {
			if (other.numTel != null)
				return false;
		} else if (!numTel.equals(other.numTel))
			return false;
		if (typeEtablissement != other.typeEtablissement)
			return false;
		if (version != other.version)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Etablissement [id=" + id + ", nom=" + nom + ", adresse=" + adresse + ", typeEtablissement="
				+ typeEtablissement + ", numTel=" + numTel + ", logo=" + logo + ", version=" + version + "]";
	}
	
	
	
	
}

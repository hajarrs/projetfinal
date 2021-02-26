package com.projetfinal.etablissement.entity;

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

@Entity
@SequenceGenerator(name = "seqEtablissement", sequenceName = "seq_etablissement", initialValue = 10, allocationSize = 1)
public class Etablissement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqEtablissement")
	private Integer id;
	
	@NotEmpty
	private String nom;
	@NotNull
	private Adresse adresse;
	@NotNull
	@Enumerated(EnumType.STRING)
	private TypeEtablissement typeEtablissement;
	@NotEmpty
	private String numTel;
	private String logo;
	@Version
	private int version;
}

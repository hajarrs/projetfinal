package com.projetfinal.etablissement.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@SequenceGenerator(name = "seqUtilisateur", sequenceName = "seq_utilisateur", initialValue = 10, allocationSize = 1)
public class Utilisateur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqUtilisateur")
	private Integer id;
	@NotNull
	private Login login;
	@NotEmpty
	private String nom, prenom;
	@Transient
	@NotNull
	private Adresse adresse;
	@NotNull
	private LocalDate dateNaissance;
	@NotNull
	@ManyToOne
	private Etablissement etablissement;
	@Version
	private int version;
}

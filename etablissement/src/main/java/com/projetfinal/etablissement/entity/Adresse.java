package com.projetfinal.etablissement.entity;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;

@Embeddable
public class Adresse {
	@NotEmpty
	private String nomRue;
	@NotEmpty
	private Integer numRue;
	@NotEmpty
	private String codePostal;
	@NotEmpty
	private String ville;
}

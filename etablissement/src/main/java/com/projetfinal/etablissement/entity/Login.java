package com.projetfinal.etablissement.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Embeddable
public class Login {
	@NotEmpty
	@Column(unique=true)
	private String login;
	@NotEmpty
	private String password;
	private boolean premiereConnexion = true;
	@NotNull
	@Enumerated(EnumType.STRING)
	private TypeUtilisateur typeUtilisateur;
}

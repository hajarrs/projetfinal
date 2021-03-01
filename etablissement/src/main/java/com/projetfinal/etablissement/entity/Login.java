package com.projetfinal.etablissement.entity;

import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

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
	
	
	public Login() {
	}


	public Login(@NotEmpty String login, @NotEmpty String password, @NotNull TypeUtilisateur typeUtilisateur) {
		this.login = login;
		this.password = password;
		this.typeUtilisateur = typeUtilisateur;
	}
	
	public Login(@NotEmpty String login, @NotNull TypeUtilisateur typeUtilisateur) {
		this.login = login;
		this.password = generatePassword();
		this.typeUtilisateur = typeUtilisateur;
	}


	public String generatePassword() {
		Random rand = new Random();
		String password="";
		for(int i = 0 ; i < 5 ; i++){
		  char c = (char)(rand.nextInt(26) + 97);
		  password += c;
		}
		return password;
	}
		
	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public boolean isPremiereConnexion() {
		return premiereConnexion;
	}


	public void setPremiereConnexion(boolean premiereConnexion) {
		this.premiereConnexion = premiereConnexion;
	}


	public TypeUtilisateur getTypeUtilisateur() {
		return typeUtilisateur;
	}


	public void setTypeUtilisateur(TypeUtilisateur typeUtilisateur) {
		this.typeUtilisateur = typeUtilisateur;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + (premiereConnexion ? 1231 : 1237);
		result = prime * result + ((typeUtilisateur == null) ? 0 : typeUtilisateur.hashCode());
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
		Login other = (Login) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (premiereConnexion != other.premiereConnexion)
			return false;
		if (typeUtilisateur != other.typeUtilisateur)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Login [login=" + login + ", password=" + password + ", premiereConnexion=" + premiereConnexion
				+ ", typeUtilisateur=" + typeUtilisateur + "]";
	}
	
	
}

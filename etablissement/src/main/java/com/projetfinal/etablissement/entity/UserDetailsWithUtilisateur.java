package com.projetfinal.etablissement.entity;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsWithUtilisateur implements UserDetails {

	private Utilisateur utilisateur;

	public UserDetailsWithUtilisateur(Utilisateur utilisateur) {
		super();
		this.utilisateur = utilisateur;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority(utilisateur.getLogin().getTypeUtilisateur().toString()));
	}

	@Override
	public String getPassword() {
		return utilisateur.getLogin().getPassword();
	}

	@Override
	public String getUsername() {
		return utilisateur.getLogin().getPassword();
	}

	public Integer getId() {
		return utilisateur.getId();
	}
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}


	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}

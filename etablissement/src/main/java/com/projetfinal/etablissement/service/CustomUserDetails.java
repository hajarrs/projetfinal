package com.projetfinal.etablissement.service;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.projetfinal.etablissement.entity.Utilisateur;

public class CustomUserDetails implements UserDetails {

	private Utilisateur user;


	public CustomUserDetails(Utilisateur user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority(user.getLogin().getTypeUtilisateur().toString()));
	}

	@Override
	public String getPassword() {
		return user.getLogin().getPassword();
	}

	@Override
	public String getUsername() {
		return user.getLogin().getLogin();
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
	
	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}

}

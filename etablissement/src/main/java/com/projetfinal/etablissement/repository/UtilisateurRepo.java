package com.projetfinal.etablissement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projetfinal.etablissement.entity.Utilisateur;

public interface UtilisateurRepo extends JpaRepository<Utilisateur, Integer>{
	@Query( "select u from Utilisateur u where u.login.login=:login" )
	public Optional<Utilisateur> findByLogin(@Param("login") String login);
	
}

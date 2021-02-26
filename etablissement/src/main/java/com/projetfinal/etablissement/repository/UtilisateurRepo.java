package com.projetfinal.etablissement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetfinal.etablissement.entity.Utilisateur;

public interface UtilisateurRepo extends JpaRepository<Utilisateur, Integer>{

}

package com.projetfinal.etablissement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetfinal.etablissement.entity.Etablissement;

public interface EtablissementRepo extends JpaRepository<Etablissement, Integer>{

}

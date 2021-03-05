package com.projetfinal.etablissement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetfinal.etablissement.entity.Professeur;
import java.util.List;

public interface ProfesseurRepo extends JpaRepository<Professeur, Integer>{

}

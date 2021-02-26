package com.projetfinal.etablissement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetfinal.etablissement.entity.Cours;

public interface CoursRepo extends JpaRepository<Cours, Integer> {

}

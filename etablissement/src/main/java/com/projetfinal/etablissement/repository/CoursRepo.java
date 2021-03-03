package com.projetfinal.etablissement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projetfinal.etablissement.entity.Cours;

public interface CoursRepo extends JpaRepository<Cours, Integer> {

	@Query("select c from Cours c where c.professeur.id=:id")
	public List<Cours> findAllForProfesseur(@Param("id") Integer id);
	
	@Query("select c from Cours c where c.salle.id=:id")
	public List<Cours> findAllForSalle(@Param("id") Integer id);
	
	
}

package com.projetfinal.etablissement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projetfinal.etablissement.entity.GroupeClasse;

public interface GroupeClasseRepo extends JpaRepository<GroupeClasse, Integer>{
	@Query("select g from GroupeClasse g where g.professeurPrincipal.id=:id")
	public List<GroupeClasse> findAllForProf(@Param("id") Integer id);
}

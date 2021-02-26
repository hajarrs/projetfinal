package com.projetfinal.etablissement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetfinal.etablissement.entity.Login;

public interface LoginRepo extends JpaRepository<Login, Integer>{

}

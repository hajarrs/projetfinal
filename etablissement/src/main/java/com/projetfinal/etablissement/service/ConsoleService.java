package com.projetfinal.etablissement.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.projetfinal.etablissement.repository.AdresseRepo;
import com.projetfinal.etablissement.repository.EtablissementRepo;
import com.projetfinal.etablissement.repository.LoginRepo;
import com.projetfinal.etablissement.repository.UtilisateurRepo;

@Service
public class ConsoleService implements CommandLineRunner {

	@Autowired
	private AdresseRepo adresseRepo;
	@Autowired
	private EtablissementRepo etablissementRepo;
	@Autowired
	private LoginRepo loginRepo;
	@Autowired
	private UtilisateurRepo utillisateurRepo;
	
	


	@Override
	public void run(String... args) throws Exception {

	}

}

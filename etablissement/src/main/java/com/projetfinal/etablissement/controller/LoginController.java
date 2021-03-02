package com.projetfinal.etablissement.controller;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.projetfinal.etablissement.entity.Utilisateur;
import com.projetfinal.etablissement.entity.Vue;
import com.projetfinal.etablissement.service.CustomUserDetails;




@RestController
@RequestMapping("/api/login")
@CrossOrigin(origins="*")
public class LoginController {
	@JsonView(Vue.Common.class)
	@GetMapping("")
	public ResponseEntity<Utilisateur> login(Authentication auth) {
		Utilisateur utilisateur = ((CustomUserDetails)auth.getPrincipal()).getUser();
		return new ResponseEntity<Utilisateur>(utilisateur,HttpStatus.OK);
	}
}
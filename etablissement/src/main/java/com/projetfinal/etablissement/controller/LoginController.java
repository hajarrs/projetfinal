package com.projetfinal.etablissement.controller;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.projetfinal.etablissement.entity.UserDetailsWithUtilisateur;
import com.projetfinal.etablissement.entity.Utilisateur;



@RestController
@RequestMapping("/api/login")
@CrossOrigin(origins="*")
public class LoginController {
	@GetMapping("")
	public ResponseEntity<Utilisateur> login(Authentication auth) {
		Utilisateur utilisateur = ((UserDetailsWithUtilisateur)auth.getPrincipal()).getUtilisateur();
		return new ResponseEntity<Utilisateur>(utilisateur,HttpStatus.OK);
	}
}
package com.projetfinal.etablissement.controller;

import java.io.Serializable;
import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.authentication.PasswordEncoderParser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonView;
import com.projetfinal.etablissement.entity.Login;
import com.projetfinal.etablissement.entity.Utilisateur;
import com.projetfinal.etablissement.entity.Vue;
import com.projetfinal.etablissement.exception.InvalidException;
import com.projetfinal.etablissement.exception.NotFoundException;
import com.projetfinal.etablissement.service.UtilisateurService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/utilisateur")
public class UtilisateurController {

	@Autowired
	private UtilisateurService utilisateurService;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@JsonView(Vue.Common.class)
	@GetMapping({ "", "/" })
	public List<Utilisateur> list() {
		return utilisateurService.allUtilisateur();
	}
	

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
		Utilisateur utilisateurEnBase = utilisateurService.find(id);
		if (utilisateurEnBase.getId() == null) {
			throw new NotFoundException();
		}
		utilisateurService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@PutMapping("/{id}")
	@JsonView(Vue.Common.class)
	public Utilisateur update(@Valid @RequestBody Utilisateur p, BindingResult br, @PathVariable("id") Integer id) {
		if (br.hasErrors()) {
			throw new InvalidException();
		}
		Utilisateur utilisateurEnBase = utilisateurService.find(id);
		if (utilisateurEnBase.getId() == null) {
			throw new NotFoundException();
		}
		utilisateurEnBase.setAdresse(p.getAdresse());
//		utilisateurEnBase.setCours(p.getCours());
		System.out.println("update"+p.getLogin().getPassword());
		utilisateurEnBase.getLogin().changePassword(passwordEncoder.encode(p.getLogin().getPassword()));
		System.out.println(utilisateurEnBase.getLogin().getPassword());
		utilisateurEnBase.setDateNaissance(p.getDateNaissance());
		utilisateurEnBase.setEtablissement(p.getEtablissement());
//		utilisateurEnBase.setLogin(p.getLogin());
		utilisateurEnBase.setNom(p.getNom());
		utilisateurEnBase.setPrenom(p.getPrenom());
		utilisateurService.save(utilisateurEnBase);
		return utilisateurEnBase;
	}

	@PostMapping({ "", "/" })
	public ResponseEntity<Utilisateur> addUtilisateur(@Valid @RequestBody Utilisateur p, BindingResult br,
			UriComponentsBuilder uCB) {
		if (br.hasErrors()) {
			throw new InvalidException();
		}
		utilisateurService.creationUtilisateur(p);
		URI uri = uCB.path("/utilisateur/{id}").buildAndExpand(p.getId()).toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);
		return new ResponseEntity<Utilisateur>(p, headers, HttpStatus.CREATED);
	}

	@JsonView(Vue.Common.class)
	@GetMapping("/{id}")
	public Utilisateur findById(@PathVariable("id") Integer id) {
		Utilisateur p = utilisateurService.find(id);
		if (p.getId() != null) {
			return p;
		}
		throw new NotFoundException();
	}
	
	@JsonView(Vue.Common.class)
	@GetMapping("/login/{login}")
	public Utilisateur findByLogin(@PathVariable("login") String login) {
		Utilisateur p = utilisateurService.findByLogin(login);
		if (p.getId() != null) {
			return p;
		}
		throw new NotFoundException();
	}

}
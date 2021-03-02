package com.projetfinal.etablissement.controller;

import java.io.Serializable;
import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.projetfinal.etablissement.entity.Professeur;
import com.projetfinal.etablissement.entity.Vue;
import com.projetfinal.etablissement.exception.InvalidException;
import com.projetfinal.etablissement.exception.NotFoundException;
import com.projetfinal.etablissement.service.ProfesseurService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/professeur")
public class ProfesseurController {

	@Autowired
	private ProfesseurService professeurService;

	@GetMapping({ "", "/" })
	public List<Professeur> list() {
		return professeurService.allProfesseur();
	}
	

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
		Professeur professeurEnBase = professeurService.find(id);
		if (professeurEnBase.getId() == null) {
			throw new NotFoundException();
		}
		professeurService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@PutMapping("/{id}")
	public Professeur update(@Valid @RequestBody Professeur p, BindingResult br, @PathVariable("id") Integer id) {
		if (br.hasErrors()) {
			throw new InvalidException();
		}
		Professeur professeurEnBase = professeurService.find(id);
		if (professeurEnBase.getId() == null) {
			throw new NotFoundException();
		}
		professeurEnBase.setAdresse(p.getAdresse());
//		professeurEnBase.setCours(p.getCours());
		professeurEnBase.setDateNaissance(p.getDateNaissance());
		professeurEnBase.setEtablissement(p.getEtablissement());
		professeurEnBase.setGroupes(p.getGroupes());
		professeurEnBase.setLogin(p.getLogin());
		professeurEnBase.setMatieres(p.getMatieres());
		professeurEnBase.setNom(p.getNom());
		professeurEnBase.setPrenom(p.getPrenom());
		professeurService.save(professeurEnBase);
		return professeurEnBase;
	}

	@PostMapping({ "", "/" })
	public ResponseEntity<Professeur> addPersonne(@Valid @RequestBody Professeur p, BindingResult br,
			UriComponentsBuilder uCB) {
		if (br.hasErrors()) {
			throw new InvalidException();
		}
		professeurService.creationProfesseur(p);
		URI uri = uCB.path("/professeur/{id}").buildAndExpand(p.getId()).toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);
		return new ResponseEntity<Professeur>(p, headers, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public Professeur findById(@PathVariable("id") Integer id) {
		Professeur p = professeurService.find(id);
		if (p.getId() != null) {
			return p;
		}
		throw new NotFoundException();
	}

}
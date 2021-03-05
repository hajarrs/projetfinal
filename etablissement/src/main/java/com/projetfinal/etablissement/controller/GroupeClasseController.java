package com.projetfinal.etablissement.controller;

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
import com.projetfinal.etablissement.entity.Cours;
import com.projetfinal.etablissement.entity.GroupeClasse;
import com.projetfinal.etablissement.entity.Vue;
import com.projetfinal.etablissement.exception.InvalidException;
import com.projetfinal.etablissement.exception.NotFoundException;
import com.projetfinal.etablissement.service.GroupeClasseService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/groupeClasse")
public class GroupeClasseController {

	@Autowired
	private GroupeClasseService groupeClasseService;

	@GetMapping({ "", "/" })
	@JsonView(Vue.CommonGroupeWithProfesseurPrincipal.class)
	public List<GroupeClasse> list() {
		System.out.println("\n\n\n List");
		return groupeClasseService.allGroupeClasse();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
		GroupeClasse groupeClasseEnBase = groupeClasseService.find(id);
		if (groupeClasseEnBase.getId() == null) {
			throw new NotFoundException();
		}
		groupeClasseService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@PutMapping("/{id}")
	public GroupeClasse update(@Valid @RequestBody GroupeClasse gc, BindingResult br, @PathVariable("id") Integer id) {
		if (br.hasErrors()) {
			throw new InvalidException();
		}
		GroupeClasse groupeClasseEnBase = groupeClasseService.find(id);
		if (groupeClasseEnBase.getId() == null) {
			throw new NotFoundException();
		}
		groupeClasseEnBase.setNom(gc.getNom());
		groupeClasseEnBase.setProfesseurPrincipal(gc.getProfesseurPrincipal());
		groupeClasseService.save(groupeClasseEnBase);
		return groupeClasseEnBase;
	}

	@PostMapping({ "", "/" })
	public ResponseEntity<GroupeClasse> addPersonne(@Valid @RequestBody GroupeClasse gc, BindingResult br,
			UriComponentsBuilder uCB) {
		if (br.hasErrors()) {
			throw new InvalidException();
		}
		groupeClasseService.creationGroupeClasse(gc);
		URI uri = uCB.path("/api/groupeClasse/{id}").buildAndExpand(gc.getId()).toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);
		return new ResponseEntity<GroupeClasse>(gc, headers, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	@JsonView(Vue.CommonGroupeWithProfesseurPrincipal.class)
	public GroupeClasse findById(@PathVariable("id") Integer id) {
		GroupeClasse gc = groupeClasseService.find(id);
		if (gc.getId() != null) {
			return gc;
		}
		throw new NotFoundException();
	}
	
	@GetMapping("/groupe/{id}")
	@JsonView(Vue.CommonGroupeWithProfesseurPrincipal.class)
	public List<GroupeClasse> findByProfId(@PathVariable("id") Integer id) {
		return groupeClasseService.findByProf(id);
	}

}
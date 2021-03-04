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
import com.projetfinal.etablissement.entity.SalleClasse;
import com.projetfinal.etablissement.entity.Vue;
import com.projetfinal.etablissement.exception.InvalidException;
import com.projetfinal.etablissement.exception.NotFoundException;
import com.projetfinal.etablissement.service.CoursService;
import com.projetfinal.etablissement.service.SalleClasseService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/salleClasse")
public class SalleClasseController {

	@Autowired
	private SalleClasseService salleClasseService;
	
	@Autowired
	private CoursService coursService;

	@GetMapping({ "", "/" })
	public List<SalleClasse> list() {
		return salleClasseService.allSalleClasse();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
		SalleClasse salleClasseEnBase = salleClasseService.find(id);
		if (salleClasseEnBase.getId() == null) {
			throw new NotFoundException();
		}
		List<Cours> listCoursToDelete = coursService.findBySalle(id);
		for (Cours cours : listCoursToDelete) {
			coursService.delete(cours.getId());
		}
		
		salleClasseService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@PutMapping("/{id}")
	public SalleClasse update(@Valid @RequestBody SalleClasse c, BindingResult br, @PathVariable("id") Integer id) {
		if (br.hasErrors()) {
			throw new InvalidException();
		}
		SalleClasse salleClasseEnBase = salleClasseService.find(id);
		if (salleClasseEnBase.getId() == null) {
			throw new NotFoundException();
		}
		salleClasseEnBase.setCapacite(c.getCapacite());
//		salleClasseEnBase.setCours(c.getCours());
		salleClasseEnBase.setMatieresExclues(c.getMatieresExclues());
		salleClasseEnBase.setNom(c.getNom());
		salleClasseService.save(salleClasseEnBase);
		return salleClasseEnBase;
	}

	@PostMapping({ "", "/" })
	public ResponseEntity<SalleClasse> addPersonne(@Valid @RequestBody SalleClasse c, BindingResult br, UriComponentsBuilder uCB) {
		if (br.hasErrors()) {
			throw new InvalidException();
		}
		salleClasseService.creationSalleClasse(c);
		URI uri = uCB.path("/api/salleClasse/{id}").buildAndExpand(c.getId()).toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);
		return new ResponseEntity<SalleClasse>(c, headers, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	@JsonView(Vue.Common.class)
	public SalleClasse findById(@PathVariable("id") Integer id) {
		SalleClasse c = salleClasseService.find(id);
		if (c.getId() != null) {
			return c;
		}
		throw new NotFoundException();
	}

}
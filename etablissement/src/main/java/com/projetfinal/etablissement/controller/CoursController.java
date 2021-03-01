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

import com.projetfinal.etablissement.entity.Cours;
import com.projetfinal.etablissement.exception.InvalidException;
import com.projetfinal.etablissement.exception.NotFoundException;
import com.projetfinal.etablissement.service.CoursService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/cours")
public class CoursController {

	@Autowired
	private CoursService coursService;

	@GetMapping({ "", "/" })
	public List<Cours> list() {
		return coursService.allCours();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
		Cours coursEnBase = coursService.find(id);
		if (coursEnBase.getId() == null) {
			throw new NotFoundException();
		}
		coursService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@PutMapping("/{id}")
	public Cours update(@Valid @RequestBody Cours c, BindingResult br, @PathVariable("id") Integer id) {
		if (br.hasErrors()) {
			throw new InvalidException();
		}
		Cours coursEnBase = coursService.find(id);
		if (coursEnBase.getId() == null) {
			throw new NotFoundException();
		}
		coursEnBase.setDateHeureDebut(c.getDateHeureDebut());
		coursEnBase.setDateHeureFin(c.getDateHeureFin());
		coursEnBase.setDay(c.getDay());
		coursEnBase.setMatiere(c.getMatiere());
		coursEnBase.setProfesseur(c.getProfesseur());
		coursEnBase.setSalle(c.getSalle());
		coursService.save(coursEnBase);
		return coursEnBase;
	}

	@PostMapping({ "", "/" })
	public ResponseEntity<Cours> addPersonne(@Valid @RequestBody Cours c, BindingResult br, UriComponentsBuilder uCB) {
		if (br.hasErrors()) {
			throw new InvalidException();
		}
		coursService.creationCours(c);
		URI uri = uCB.path("/cours/{id}").buildAndExpand(c.getId()).toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);
		return new ResponseEntity<Cours>(c, headers, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public Cours findById(@PathVariable("id") Integer id) {
		Cours c = coursService.find(id);
		if (c.getId() != null) {
			return c;
		}
		throw new NotFoundException();
	}

}
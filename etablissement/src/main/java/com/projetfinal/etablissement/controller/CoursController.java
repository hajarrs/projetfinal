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
import com.projetfinal.etablissement.entity.Vue;
import com.projetfinal.etablissement.exception.InvalidException;
import com.projetfinal.etablissement.exception.NotFoundException;
import com.projetfinal.etablissement.exception.OverlapException;
import com.projetfinal.etablissement.service.CoursService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/cours")
public class CoursController {

	@Autowired
	private CoursService coursService;

	@GetMapping({ "", "/" })
	@JsonView(Vue.Common.class)
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
	@JsonView(Vue.Common.class)
	public Cours update(@Valid @RequestBody Cours c, BindingResult br, @PathVariable("id") Integer id) {
		if (br.hasErrors()) {
			System.out.println("Test");
			throw new InvalidException();
		}
		Cours coursEnBase = coursService.find(id);
		if (coursEnBase.getId() == null) {
			throw new NotFoundException();
		}
		coursEnBase.setHeureDebut(c.getHeureDebut());
		coursEnBase.setHeureFin(c.getHeureFin());
		coursEnBase.setDay(c.getDay());
		coursEnBase.setMatiere(c.getMatiere());
		coursEnBase.setProfesseur(c.getProfesseur());
		coursEnBase.setSalle(c.getSalle());
		Cours result = coursService.save(coursEnBase);
		if (result == null) {
			throw new OverlapException();
		}
		System.out.println("\n\n\n\n\n The day"+c.getDay());
		return result;
	}

	@PostMapping({ "", "/" })
	@JsonView(Vue.Common.class)
	public ResponseEntity<Cours> addCours(@Valid @RequestBody Cours c, BindingResult br, UriComponentsBuilder uCB) {
		if (br.hasErrors()) {
			throw new InvalidException();
		}
		Cours result = coursService.creationCours(c);
		if (result == null) {
			throw new InvalidException();
		}
		URI uri = uCB.path("/api/cours/{id}").buildAndExpand(result.getId()).toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);
		return new ResponseEntity<Cours>(result, headers, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	@JsonView(Vue.Common.class)
	public Cours findById(@PathVariable("id") Integer id) {
		Cours c = coursService.find(id);
		if (c.getId() != null) {
			return c;
		}
		throw new NotFoundException();
	}

	@GetMapping("/professeur/{id}")
	@JsonView(Vue.Common.class)
	public List<Cours> findByProfesseurId(@PathVariable("id") Integer id) {
		return coursService.findByProf(id);
	}

	@GetMapping("/salle/{id}")
	@JsonView(Vue.Common.class)
	public List<Cours> findBySalleId(@PathVariable("id") Integer id) {
		return coursService.findBySalle(id);
	}

	
	
}
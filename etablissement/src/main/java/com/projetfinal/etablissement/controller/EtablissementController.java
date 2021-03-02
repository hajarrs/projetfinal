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

import com.projetfinal.etablissement.entity.Etablissement;
import com.projetfinal.etablissement.exception.InvalidException;
import com.projetfinal.etablissement.exception.NotFoundException;
import com.projetfinal.etablissement.service.EtablissementService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/etablissement")
public class EtablissementController {

	@Autowired
	private EtablissementService etablissementService;

	@GetMapping({ "", "/" })
	public List<Etablissement> list() {
		return etablissementService.allEtablissement();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
		Etablissement etablissementEnBase = etablissementService.find(id);
		if (etablissementEnBase.getId() == null) {
			throw new NotFoundException();
		}
		etablissementService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@PutMapping("/{id}")
	public Etablissement update(@Valid @RequestBody Etablissement e, BindingResult br, @PathVariable("id") Integer id) {
		if (br.hasErrors()) {
			throw new InvalidException();
		}
		Etablissement etablissementEnBase = etablissementService.find(id);
		if (etablissementEnBase.getId() == null) {
			throw new NotFoundException();
		}
		etablissementEnBase.setAdresse(e.getAdresse());
		etablissementEnBase.setLogo(e.getLogo());
		etablissementEnBase.setNom(e.getNom());
		etablissementEnBase.setNumTel(e.getNumTel());
		etablissementEnBase.setTypeEtablissement(e.getTypeEtablissement());
		etablissementService.save(etablissementEnBase);
		return etablissementEnBase;
	}

	@PostMapping({ "", "/" })
	public ResponseEntity<Etablissement> addPersonne(@Valid @RequestBody Etablissement e, BindingResult br,
			UriComponentsBuilder uCB) {
		if (br.hasErrors()) {
			throw new InvalidException();
		}
		etablissementService.creationEtablissement(e);
		URI uri = uCB.path("/etablissement/{id}").buildAndExpand(e.getId()).toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);
		return new ResponseEntity<Etablissement>(e, headers, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public Etablissement findById(@PathVariable("id") Integer id) {
		Etablissement e = etablissementService.find(id);
		if (e.getId() != null) {
			return e;
		}
		throw new NotFoundException();
	}

}
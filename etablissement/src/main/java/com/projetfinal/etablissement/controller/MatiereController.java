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

import com.projetfinal.etablissement.entity.Matiere;
import com.projetfinal.etablissement.exception.InvalidException;
import com.projetfinal.etablissement.exception.NotFoundException;
import com.projetfinal.etablissement.service.MatiereService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/matiere")
public class MatiereController {

	@Autowired
	private MatiereService matiereService;

	@GetMapping({ "", "/" })
	public List<Matiere> list() {
		return matiereService.allMatiere();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
		Matiere matiereEnBase = matiereService.find(id);
		if (matiereEnBase.getId() == null) {
			throw new NotFoundException();
		}
		matiereService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@PutMapping("/{id}")
	public Matiere update(@Valid @RequestBody Matiere m, BindingResult br, @PathVariable("id") Integer id) {
		if (br.hasErrors()) {
			throw new InvalidException();
		}
		Matiere matiereEnBase = matiereService.find(id);
		if (matiereEnBase.getId() == null) {
			throw new NotFoundException();
		}
		matiereEnBase.setCouleur(m.getCouleur());
//		matiereEnBase.setCours(m.getCours());
		matiereEnBase.setNom(m.getNom());
//		matiereEnBase.setProfesseurs(m.getProfesseurs());
//		matiereEnBase.setSalles(m.getSalles());
		matiereService.save(matiereEnBase);
		return matiereEnBase;
	}

	@PostMapping({ "", "/" })
	public ResponseEntity<Matiere> addPersonne(@Valid @RequestBody Matiere m, BindingResult br,
			UriComponentsBuilder uCB) {
		if (br.hasErrors()) {
			throw new InvalidException();
		}
		matiereService.creationMatiere(m);
		URI uri = uCB.path("/matiere/{id}").buildAndExpand(m.getId()).toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);
		return new ResponseEntity<Matiere>(m, headers, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public Matiere findById(@PathVariable("id") Integer id) {
		Matiere c = matiereService.find(id);
		if (c.getId() != null) {
			return c;
		}
		throw new NotFoundException();
	}

}
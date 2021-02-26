package com.projetfinal.etablissement.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.projetfinal.etablissement.entity.Professeur;
import com.projetfinal.etablissement.service.ProfesseurService;

@Controller
@RequestMapping("/professeur")
public class ProfesseurController {

	@Autowired
	private ProfesseurService professeurService;

	@GetMapping("")
	public String list(Model model) {
		model.addAttribute("professeurs", professeurService.allProfesseur());
		Professeur p = new Professeur();
		return "professeur/list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam Integer id) {
		professeurService.delete(id);
		return "redirect:/professeur";
	}

	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("personne") Professeur professeur, BindingResult br, Model model) {
		if (br.hasErrors()) {
			return goEdit(professeur, model);
		}
		professeurService.save(professeur);
		return "redirect:/professeur";
	}

	@GetMapping("/edit")
	public String edit(@RequestParam Integer id, Model model) {
		return goEdit(professeurService.find(id), model);
	}

	@GetMapping("/add")
	public String add(Model model) {
		return goEdit(new Professeur(), model);
	}

	private String goEdit(Professeur professeur, Model model) {
		model.addAttribute("professeur", professeur);
		// si on a des donnees en plus dans le model on ecrit le code 1 fois
		return "professeur/editAvecSpring";
	}

}
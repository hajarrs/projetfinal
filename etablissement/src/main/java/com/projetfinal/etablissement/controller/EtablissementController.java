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

import com.projetfinal.etablissement.entity.Etablissement;
import com.projetfinal.etablissement.service.EtablissementService;

@Controller
@RequestMapping("/etablissement")
public class EtablissementController {

	@Autowired
	private EtablissementService etablissementService;

	@GetMapping("")
	public String list(Model model) {
		model.addAttribute("etablissements", etablissementService.allEtablissement());
		Etablissement p = new Etablissement();
		return "etablissement/list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam Integer id) {
		etablissementService.delete(id);
		return "redirect:/etablissement";
	}

	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("etablissement") Etablissement etablissement, BindingResult br,
			Model model) {
		if (br.hasErrors()) {
			return goEdit(etablissement, model);
		}
		etablissementService.save(etablissement);
		return "redirect:/etablissement";
	}

	@GetMapping("/edit")
	public String edit(@RequestParam Integer id, Model model) {
		return goEdit(etablissementService.find(id), model);
	}

	@GetMapping("/add")
	public String add(Model model) {
		return goEdit(new Etablissement(), model);
	}

	private String goEdit(Etablissement etablissement, Model model) {
		model.addAttribute("etablissement", etablissement);
		// si on a des donnees en plus dans le model on ecrit le code 1 fois
		return "etablissement/editAvecSpring";
	}

}
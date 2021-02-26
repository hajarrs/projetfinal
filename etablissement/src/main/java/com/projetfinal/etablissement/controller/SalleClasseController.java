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

import com.projetfinal.etablissement.entity.SalleClasse;
import com.projetfinal.etablissement.service.SalleClasseService;

@Controller
@RequestMapping("/salleClasse")
public class SalleClasseController {

	@Autowired
	private SalleClasseService salleClasseService;

	@GetMapping("")
	public String list(Model model) {
		model.addAttribute("salleClasses", salleClasseService.allSalleClasse());
		SalleClasse s = new SalleClasse();
		return "salle/list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam Integer id) {
		salleClasseService.delete(id);
		return "redirect:/salle";
	}

	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("salle") SalleClasse salle, BindingResult br, Model model) {
		if (br.hasErrors()) {
			return goEdit(salle, model);
		}
		salleClasseService.save(salle);
		return "redirect:/salle";
	}

	@GetMapping("/edit")
	public String edit(@RequestParam Integer id, Model model) {
		return goEdit(salleClasseService.find(id), model);
	}

	@GetMapping("/add")
	public String add(Model model) {
		return goEdit(new SalleClasse(), model);
	}

	private String goEdit(SalleClasse salleClasse, Model model) {
		model.addAttribute("salleClasse", salleClasse);
		// si on a des donnees en plus dans le model on ecrit le code 1 fois
		return "salleClasse/editAvecSpring";
	}

}
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

import com.projetfinal.etablissement.entity.Cours;
import com.projetfinal.etablissement.service.CoursService;

@Controller
@RequestMapping("/cours")
public class CoursController {

	@Autowired
	private CoursService coursService;

	@GetMapping("")
	public String list(Model model) {
		model.addAttribute("cours", coursService.allCours());
		Cours p = new Cours();
		return "cours/list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam Integer id) {
		coursService.delete(id);
		return "redirect:/cours";
	}

	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("cours") Cours cours, BindingResult br, Model model) {
		if (br.hasErrors()) {
			return goEdit(cours, model);
		}
		coursService.save(cours);
		return "redirect:/cours";
	}

	@GetMapping("/edit")
	public String edit(@RequestParam Integer id, Model model) {
		return goEdit(coursService.find(id), model);
	}

	@GetMapping("/add")
	public String add(Model model) {
		return goEdit(new Cours(), model);
	}

	private String goEdit(Cours cours, Model model) {
		model.addAttribute("cours", cours);
		// si on a des donnees en plus dans le model on ecrit le code 1 fois
		return "cours/editAvecSpring";
	}

}
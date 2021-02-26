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

import com.projetfinal.etablissement.entity.GroupeClasse;
import com.projetfinal.etablissement.service.GroupeClasseService;

@Controller
@RequestMapping("/groupeClasse")
public class GroupeClasseController {

	@Autowired
	private GroupeClasseService groupeClasseService;

	@GetMapping("")
	public String list(Model model) {
		model.addAttribute("groupeClasses", groupeClasseService.allGroupeClasse());
		GroupeClasse p = new GroupeClasse();
		return "professeur/list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam Integer id) {
		groupeClasseService.delete(id);
		return "redirect:/groupeClasse";
	}

	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("groupeClasse") GroupeClasse groupeClasse, BindingResult br, Model model) {
		if (br.hasErrors()) {
			return goEdit(groupeClasse, model);
		}
		groupeClasseService.save(groupeClasse);
		return "redirect:/professeur";
	}

	@GetMapping("/edit")
	public String edit(@RequestParam Integer id, Model model) {
		return goEdit(groupeClasseService.find(id), model);
	}

	@GetMapping("/add")
	public String add(Model model) {
		return goEdit(new GroupeClasse(), model);
	}

	private String goEdit(GroupeClasse groupeClasse, Model model) {
		model.addAttribute("groupeClasse", groupeClasse);
		// si on a des donnees en plus dans le model on ecrit le code 1 fois
		return "groupeClasse/editAvecSpring";
	}

}
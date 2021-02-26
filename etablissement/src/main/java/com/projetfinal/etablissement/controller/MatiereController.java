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

import com.projetfinal.etablissement.entity.Matiere;
import com.projetfinal.etablissement.service.MatiereService;

@Controller
@RequestMapping("/matiere")
public class MatiereController {

	@Autowired
	private MatiereService matiereService;

	@GetMapping("")
	public String list(Model model) {
		model.addAttribute("matieres", matiereService.allMatiere());
		Matiere p = new Matiere();
		return "matiere/list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam Integer id) {
		matiereService.delete(id);
		return "redirect:/matiere";
	}

	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("matiere") Matiere matiere, BindingResult br, Model model) {
		if (br.hasErrors()) {
			return goEdit(matiere, model);
		}
		matiereService.save(matiere);
		return "redirect:/matiere";
	}

	@GetMapping("/edit")
	public String edit(@RequestParam Integer id, Model model) {
		return goEdit(matiereService.find(id), model);
	}

	@GetMapping("/add")
	public String add(Model model) {
		return goEdit(new Matiere(), model);
	}

	private String goEdit(Matiere matiere, Model model) {
		model.addAttribute("matiere", matiere);
		// si on a des donnees en plus dans le model on ecrit le code 1 fois
		return "matiere/editAvecSpring";
	}

}
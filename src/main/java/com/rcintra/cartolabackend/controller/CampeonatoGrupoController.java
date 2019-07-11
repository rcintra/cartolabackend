package com.rcintra.cartolabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rcintra.cartolabackend.repository.CampeonatoRepository;
import com.rcintra.cartolabackend.repository.GrupoRepository;

@Controller
@RequestMapping("/campeonato/grupo/")
public class CampeonatoGrupoController {
	
	@Autowired
	private GrupoRepository grupoRepository;
	
	@Autowired
	private CampeonatoRepository campeonatoRepository;

	@GetMapping("/home")
	public String index(Model model) {
		AssociarGruposCampeonatoForm form = new AssociarGruposCampeonatoForm();
		
		model.addAttribute("form", form);
		model.addAttribute("grupos", grupoRepository.findAll());
		model.addAttribute("campeonatos", campeonatoRepository.findAll());
		return "campeonato-grupo";
	}
}

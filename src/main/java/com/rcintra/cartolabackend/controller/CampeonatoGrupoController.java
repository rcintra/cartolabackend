package com.rcintra.cartolabackend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/campeonato/grupo/")
public class CampeonatoGrupoController {

	@GetMapping("/home")
	public String index(Model model) {
		return "campeonato-grupo";
	}
}

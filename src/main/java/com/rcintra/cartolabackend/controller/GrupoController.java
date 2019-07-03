package com.rcintra.cartolabackend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rcintra.cartolabackend.domain.Grupo;
import com.rcintra.cartolabackend.service.GrupoService;

@RestController
public class GrupoController {
	
	private GrupoService grupoService;
	
	public GrupoController(GrupoService grupoService) {
		this.grupoService = grupoService;
	}

	@GetMapping("/grupos")
	List<Grupo> grupos() {
		return grupoService.findAll();
	}
	
}

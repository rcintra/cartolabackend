package com.rcintra.cartolabackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rcintra.cartolabackend.domain.Grupo;
import com.rcintra.cartolabackend.repository.GrupoRepository;

@RestController
public class GrupoController {
	
	private GrupoRepository grupoRepository;
	
	public GrupoController(GrupoRepository grupoRepository) {
		this.grupoRepository = grupoRepository;
	}

	@GetMapping("/grupos")
	Iterable<Grupo> grupos() {
		return grupoRepository.findAll();
	}
	
}

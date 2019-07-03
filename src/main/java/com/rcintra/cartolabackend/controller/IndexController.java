package com.rcintra.cartolabackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rcintra.cartolabackend.domain.Grupo;
import com.rcintra.cartolabackend.repository.GrupoRepository;

@RestController
public class IndexController {
	
	GrupoRepository grupoRepository;
	
	public IndexController(GrupoRepository grupoRepository) {
		this.grupoRepository = grupoRepository;
	}

	@GetMapping("/")
	String hello() {
		return "Hello Cartola BackEnd";
	}
	
	@GetMapping("/grupos")
	Iterable<Grupo> grupos() {
		return grupoRepository.findAll();
	}
}

package com.rcintra.cartolabackend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rcintra.cartolabackend.domain.Grupo;
import com.rcintra.cartolabackend.grupo.Grupos;
import com.rcintra.cartolabackend.repository.GrupoRepository;

@RestController
public class GrupoController {
	
	private final GrupoRepository grupoRepository;

	public GrupoController(GrupoRepository grupoRepository) {
		this.grupoRepository = grupoRepository;
	}
	
	@GetMapping("/grupos")
	List<Grupo> grupos() {
		Grupos grupos = new Grupos();
		grupos.getGrupoList().addAll(this.grupoRepository.findAll());
		return grupos.getGrupoList();
	}
	
}

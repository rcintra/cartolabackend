package com.rcintra.cartolabackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rcintra.cartolabackend.domain.Grupo;
import com.rcintra.cartolabackend.service.impl.GrupoServiceImpl;

@RestController
public class GrupoController {

	@Autowired
	private GrupoServiceImpl grupoService;
	
	@GetMapping("/grupos")
	List<Grupo> grupos() {
		return grupoService.findAll();
	}
	
}

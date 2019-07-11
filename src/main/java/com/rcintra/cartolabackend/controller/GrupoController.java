package com.rcintra.cartolabackend.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rcintra.cartolabackend.dto.GrupoDto;
import com.rcintra.cartolabackend.repository.GrupoRepository;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/grupo/")
public class GrupoController {
	
	private final GrupoRepository grupoRepository;
	
	@GetMapping("list")
	public String showUpdateForm(Model model) {
		model.addAttribute("grupos", grupoRepository.findAll());
		return "grupo";
	}
	
	@RequestMapping(value = { "grupos.json", "grupos.xml" })
    public @ResponseBody List<GrupoDto> showResourcesGrupoList() {
        return grupoRepository.findAll().stream().map(g -> new GrupoDto(g))
        		.collect(Collectors.toList());
    }
	
}

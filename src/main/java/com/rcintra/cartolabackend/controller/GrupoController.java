package com.rcintra.cartolabackend.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.rcintra.cartolabackend.dto.GrupoDto;
import com.rcintra.cartolabackend.model.Grupo;
import com.rcintra.cartolabackend.repository.GrupoRepository;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/grupo/")
public class GrupoController {
	
	private final GrupoRepository repository;
	
	@GetMapping({"/home", "/index"})
	public ModelAndView index() {
		
		ModelAndView model = new ModelAndView("grupo/index");
		
		model.addObject("grupos", repository.findAll());
		
		return model;
	}
	
	@GetMapping("/add")
	public ModelAndView add(Grupo grupo) {
		
		ModelAndView model = new ModelAndView("grupo/add");
		model.addObject("grupo", grupo);
		
		return model;
	}
	
	@PostMapping("/save")
	public ModelAndView save(@Valid Grupo grupo, BindingResult result) {
		
		if(result.hasErrors()) {
			return add(grupo);
		}
		
		repository.save(grupo);
		
		return index();
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Integer id) {
		
		repository.deleteById(id);
		
		return index();
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Integer id) {
		
		return add(repository.findByIdOrError(id));
	}
	
	@GetMapping("list")
	public String showUpdateForm(Model model) {
		model.addAttribute("grupos", repository.findAll());
		return "grupo";
	}
	
	@RequestMapping(value = { "grupos.json", "grupos.xml" })
    public @ResponseBody List<GrupoDto> showResourcesGrupoList() {
        return repository.findAll().stream().map(g -> new GrupoDto(g))
        		.collect(Collectors.toList());
    }
	
}

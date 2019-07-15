package com.rcintra.cartolabackend.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rcintra.cartolabackend.model.Rodada;
import com.rcintra.cartolabackend.repository.RodadaRepository;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/rodada/")
@AllArgsConstructor
public class RodadaController {
	
	private final RodadaRepository repository;

	@GetMapping({"/home", "/index"})
	public ModelAndView index() {
		
		ModelAndView model = new ModelAndView("rodada/index");
		
		model.addObject("rodadas", repository.findAll());
		
		return model;
	}
	
	@GetMapping("/add")
	public ModelAndView add(Rodada rodada) {
		
		ModelAndView model = new ModelAndView("rodada/add");
		model.addObject("rodada", rodada);
		
		return model;
	}
	
	@PostMapping("/save")
	public ModelAndView save(@Valid Rodada rodada, BindingResult result) {
		
		if(result.hasErrors()) {
			return add(rodada);
		}
		
		repository.save(rodada);
		
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
	
}

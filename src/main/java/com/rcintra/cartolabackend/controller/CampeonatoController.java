package com.rcintra.cartolabackend.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.rcintra.cartolabackend.dto.CampeonatoDto;
import com.rcintra.cartolabackend.model.Campeonato;
import com.rcintra.cartolabackend.repository.CampeonatoRepository;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/campeonato/")
@AllArgsConstructor
public class CampeonatoController {
	
	private final CampeonatoRepository repository;

	@RequestMapping(value = { "campeonatos.json", "campeonatos.xml" })
    public @ResponseBody List<CampeonatoDto> showResourcesCampeonatoList() {
        return repository.findAll().stream().map(c -> new CampeonatoDto(c))
        		.collect(Collectors.toList());
    }
	
	@GetMapping({"/home", "/index"})
	public ModelAndView index() {
		
		ModelAndView model = new ModelAndView("campeonato/index");
		
		model.addObject("campeonatos", repository.findAll());
		
		return model;
	}
	
	@GetMapping("/add")
	public ModelAndView add(Campeonato campeonato) {
		
		ModelAndView model = new ModelAndView("campeonato/add");
		model.addObject("campeonato", campeonato);
		
		return model;
	}
	
	@PostMapping("/save")
	public ModelAndView save(@Valid Campeonato campeonato, BindingResult result) {
		
		if(result.hasErrors()) {
			return add(campeonato);
		}
		
		repository.save(campeonato);
		
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

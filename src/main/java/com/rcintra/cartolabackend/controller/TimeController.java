package com.rcintra.cartolabackend.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.rcintra.cartolabackend.dto.TimeDto;
import com.rcintra.cartolabackend.repository.TimeRepository;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/time/")
public class TimeController {

	private TimeRepository repository;
	
	@GetMapping({"/home", "/index"})
	public ModelAndView index() {
		
		ModelAndView model = new ModelAndView("time/index");
		
		model.addObject("times", repository.findAll());
		
		return model;
	}
	
	@RequestMapping(value = { "/times.json", "/times.xml" })
    public @ResponseBody List<TimeDto> showResourcesGrupoList() {
        return repository.findAll().stream().map(t -> new TimeDto(t))
        		.collect(Collectors.toList());
    }
	
}

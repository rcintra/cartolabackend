package com.rcintra.cartolabackend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rcintra.cartolabackend.model.Grupo;
import com.rcintra.cartolabackend.model.Time;
import com.rcintra.cartolabackend.repository.GrupoRepository;
import com.rcintra.cartolabackend.repository.TimeRepository;


@Controller
@RequestMapping("/grupo")
public class GrupoTimeController {
	
	@Autowired
	private GrupoRepository grupoRepository;
	
	@Autowired
	private TimeRepository timeRepository;
	
	@GetMapping("/grupo_time")
	public ModelAndView grupoTime() {
		
		ModelAndView model = new ModelAndView("grupo/grupo_time");
		model.getModel().remove("grupo");
		model.addObject("grupos", grupoRepository.findAll());
		
		return model;
	}
	
	@GetMapping("/grupo_time/grupo/{id}")
	public ModelAndView selecionarGrupo(@PathVariable("id") Integer id) {
		ModelAndView model = new ModelAndView("grupo/grupo_time");
		Grupo grupoSelecionado = grupoRepository.findByIdOrError(id);
		
		model.addObject("timesAssociados", grupoSelecionado.getTimes());
		model.addObject("timesNaoAssociados", consultarTimesNaoAssociados(grupoSelecionado.getTimes()));
		model.addObject("grupos", grupoRepository.findAll());
		model.addObject("grupo", grupoSelecionado);
		
		return model;
	}
	
	private List<Time> consultarTimesNaoAssociados(List<Time> timesAssociados) {
		List<Time> timesNaoAssociados = new ArrayList<>();
		for (Time t : timeRepository.findAll()) {
			if (!timesAssociados.contains(t))
				timesNaoAssociados.add(t);
		}
		return timesNaoAssociados;
	}
	
	@PostMapping("/grupo_time/save")
	public ModelAndView save(Grupo grupo) {
		
		ModelAndView model = new ModelAndView("grupo/grupo_time");
		grupoRepository.save(grupo);
		
		model.addObject("timesAssociados", grupo.getTimes());
		model.addObject("timesNaoAssociados", consultarTimesNaoAssociados(grupo.getTimes()));
		model.addObject("grupos", grupoRepository.findAll());
		model.addObject("grupo", grupo);
		model.addObject("messageSuccess", "Grupo x Time alterado com sucesso.");
		
		return model;
	}
	
}

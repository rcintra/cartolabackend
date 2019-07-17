package com.rcintra.cartolabackend.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rcintra.cartolabackend.controller.form.RodadaTimeForm;
import com.rcintra.cartolabackend.model.RodadaTime;
import com.rcintra.cartolabackend.repository.RodadaRepository;
import com.rcintra.cartolabackend.repository.RodadaTimeRepository;
import com.rcintra.cartolabackend.repository.TimeRepository;

@Controller
@RequestMapping("/rodada")
public class RodadaTimeController {
	
	@Autowired
	private RodadaTimeRepository repository;
	
	@Autowired
	private RodadaRepository rodadaRepository;
	
	@Autowired
	private TimeRepository timeRepository;

	@GetMapping( {"/rodada_time", "/rodada_time/index", "/rodada_time/home"})
	public ModelAndView rodadaTime() {
		
		ModelAndView model = new ModelAndView("rodada/rodada_time");
		model.addObject("rodadasTimes", repository.findAll());
		
		return model;
	}
	
	
	@GetMapping("/rodada_time/add")
	public ModelAndView add(RodadaTimeForm form) {
		
		ModelAndView model = new ModelAndView("rodada/add_rodada_time");
		
		model.addObject("rodadaTimeForm", form);
		model.addObject("rodadas", rodadaRepository.findAll());
		model.addObject("times", timeRepository.findAll());
		
		
		return model;
	}
	
	@PostMapping("/rodada_time/save")
	public ModelAndView save(@Valid RodadaTimeForm form, BindingResult result) {
		
		if(result.hasErrors()) {
			return add(form);
		}
		
		repository.save(converterFormToEntity(form));
		
		return rodadaTime();
	}
	
	@GetMapping("/rodada_time/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Integer id) {
		repository.delete(id);
		return rodadaTime();
	}
	
	@GetMapping("/rodada_time/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Integer id) {
		return add(converterEntityToForm(repository.findOne(id)));
	}
	
	private RodadaTime converterFormToEntity(RodadaTimeForm form) {
		RodadaTime r = new RodadaTime();
		if (form.getId() != null)
			r = repository.findOne(form.getId());
		r.setRodada(rodadaRepository.findOne(form.getRodadaId()));
		r.setTime(timeRepository.findOne(form.getTimeId()));
		r.setPontos(form.getPontos());
		return r;
	}
	
	private RodadaTimeForm converterEntityToForm(RodadaTime rodadaTime) {
		RodadaTimeForm form = new RodadaTimeForm();
		form.setId(rodadaTime.getId());
		form.setRodadaId(rodadaTime.getRodada().getId());
		form.setTimeId(rodadaTime.getTime().getId());
		form.setPontos(rodadaTime.getPontos());
		return form;
	}
	
}

package com.rcintra.cartolabackend.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rcintra.cartolabackend.dto.TimeDto;
import com.rcintra.cartolabackend.repository.TimeRepository;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class TimeController {

	private TimeRepository timeRepository;
	
	@RequestMapping(value = { "/times.json", "/times.xml" })
    public @ResponseBody List<TimeDto> showResourcesGrupoList() {
        return timeRepository.findAll().stream().map(t -> new TimeDto(t))
        		.collect(Collectors.toList());
    }
	
}

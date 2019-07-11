package com.rcintra.cartolabackend.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rcintra.cartolabackend.dto.CampeonatoDto;
import com.rcintra.cartolabackend.repository.CampeonatoRepository;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/campeonato/")
@AllArgsConstructor
public class CampeonatoController {
	
	private final CampeonatoRepository campeonatoRepository;

	@RequestMapping(value = { "campeonatos.json", "campeonatos.xml" })
    public @ResponseBody List<CampeonatoDto> showResourcesCampeonatoList() {
        return campeonatoRepository.findAll().stream().map(c -> new CampeonatoDto(c))
        		.collect(Collectors.toList());
    }
}

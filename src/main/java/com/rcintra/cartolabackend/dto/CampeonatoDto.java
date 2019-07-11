package com.rcintra.cartolabackend.dto;

import com.rcintra.cartolabackend.model.Campeonato;

public class CampeonatoDto extends BaseDto {
	
	public CampeonatoDto(Campeonato campeonato) {
		super(campeonato.getId(), campeonato.getNome());
	}

}

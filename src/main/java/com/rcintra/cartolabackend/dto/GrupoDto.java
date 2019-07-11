package com.rcintra.cartolabackend.dto;

import com.rcintra.cartolabackend.model.Grupo;

public class GrupoDto extends BaseDto {
	
	public GrupoDto(Grupo grupo) {
		super(grupo.getId(), grupo.getNome());
	}

}

package com.rcintra.cartolabackend.dto;

import com.rcintra.cartolabackend.model.Grupo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GrupoDto {
	
	private Integer id;
	private String nome;
	
	public GrupoDto(Grupo grupo) {
		this(grupo.getId(), grupo.getNome());
	}

}

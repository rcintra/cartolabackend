package com.rcintra.cartolabackend.dto;

import com.rcintra.cartolabackend.model.Time;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TimeDto {
	private Integer id;
	private String nome;
	private String nomeTime;
	private String slug;
	private Integer timeId;
	
	public TimeDto(Time time) {
		this(time.getId(), time.getNome(), time.getNomeTime(), time.getSlug(), time.getTimeId());
	}

}

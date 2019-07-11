package com.rcintra.cartolabackend.dto;

import com.rcintra.cartolabackend.model.Time;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TimeDto extends BaseDto {
	private String nomeTime;
	private String slug;
	private Integer timeId;
	
	public TimeDto(Integer id, String nome, String nomeTime, String slug, Integer timeId) {
		super(id, nome);
		this.nomeTime = nomeTime;
		this.slug	  = slug;
		this.timeId	  = timeId;
	}
	
	public TimeDto(Time time) {
		super(time.getId(), time.getNome());
	}

}

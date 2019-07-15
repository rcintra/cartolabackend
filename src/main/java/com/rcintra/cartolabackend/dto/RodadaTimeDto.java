package com.rcintra.cartolabackend.dto;

import java.math.BigDecimal;

import com.rcintra.cartolabackend.model.Rodada;
import com.rcintra.cartolabackend.model.Time;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RodadaTimeDto {
	
	private Time time;
	private Rodada rodada;
	private BigDecimal pontos;
	private BigDecimal total;

}

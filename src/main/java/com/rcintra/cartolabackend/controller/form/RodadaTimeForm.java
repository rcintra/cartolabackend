package com.rcintra.cartolabackend.controller.form;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class RodadaTimeForm {
	
	private Integer id;
	
	@NotNull(message="Por favor, selecione uma rodada")
	private Integer rodadaId;
	
	@NotNull(message="Por favor, selecione um time")
	private Integer timeId;
	
	@NotNull(message="Por favor, incluir um valor de pontos")
	@DecimalMin(value="0.0", inclusive=true, message="Os pontos tem que ser maior que zero")
	private BigDecimal pontos;
	
}

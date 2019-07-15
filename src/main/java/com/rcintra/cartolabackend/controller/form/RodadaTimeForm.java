package com.rcintra.cartolabackend.controller.form;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class RodadaTimeForm {
	
	@NotNull
	private Integer rodadaId;
	@NotNull
	private Integer timeId;
	
	@DecimalMin(value="0,0", inclusive=true, message="Os pontos tem que ser maior que zero")
	@Pattern(regexp="^\\d{1,3}(?:\\.\\d{3})*,\\d{2}$")
	private BigDecimal pontos;
	
	

}

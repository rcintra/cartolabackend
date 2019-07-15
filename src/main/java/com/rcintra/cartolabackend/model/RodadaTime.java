package com.rcintra.cartolabackend.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="rodada_time")
public class RodadaTime {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@ManyToOne
    @JoinColumn(name = "rodada_id")
	private Rodada rodada;
	
	@NotNull
	@ManyToOne
    @JoinColumn(name = "time_id")
	private Time time;
	
	@Column(name = "pontos")
	private BigDecimal pontos;
	
}

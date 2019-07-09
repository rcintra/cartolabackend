package com.rcintra.cartolabackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="time")
public class Time{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank 
	@Column(name = "nome")
    private String nome;
	
	@Column(name="nome_time")
	private String nomeTime;
	
	@Size(max=30)
	private String slug;
	
	@Column(name="time_id")
	private Integer timeId; // id do cartola
	
}

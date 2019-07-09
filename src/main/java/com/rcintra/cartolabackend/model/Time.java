package com.rcintra.cartolabackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.rcintra.cartolabackend.model.json.TimeDeserializer;

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
	@Size(max=100)
    private String nome;
	
	@Column(name="nome_time")
	@Size(max=100)
	private String nomeTime;
	
	@Size(max=50)
	private String slug;
	
	@Column(name="time_id")
	private Integer timeId; // id do cartola
	
	public Time(TimeDeserializer time) {
		this(null, time.getNome(), time.getNome_cartola(), time.getSlug(), time.getTime_id());
	}
	
}

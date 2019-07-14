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
	
	public Time() {}
	
	public Time(String nome, String nomeTime, String slug, Integer timeId) {
		this.nome = nome;
		this.nomeTime = nomeTime;
		this.slug = slug;
		this.timeId = timeId;
	}
	
	public Time(TimeDeserializer time) {
		this(time.getNome_cartola(), time.getNome(), time.getSlug(), time.getTime_id());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeTime() {
		return nomeTime;
	}

	public void setNomeTime(String nomeTime) {
		this.nomeTime = nomeTime;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public Integer getTimeId() {
		return timeId;
	}

	public void setTimeId(Integer timeId) {
		this.timeId = timeId;
	}

}

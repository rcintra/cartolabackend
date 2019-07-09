package com.rcintra.cartolabackend.model.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class TimeDeserializer {
	private Integer time_id;
	private String nome;
	private String nome_cartola;
	private String slug;
}

package com.rcintra.cartolabackend.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="grupo")
public class Grupo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank 
	@Column(name = "nome")
	@Size(max=100)
    private String nome;

	@ManyToMany
	@JoinTable(
	   name="grupo_time",
	   joinColumns= @JoinColumn(name="grupo_id", referencedColumnName="id"),
	   inverseJoinColumns=@JoinColumn(name="time_id", referencedColumnName="id"))
	private List<Time> times;
	
}

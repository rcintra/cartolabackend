package com.rcintra.cartolabackend.model;

import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name="campeonato")
public class Campeonato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank 
	@Column(name = "nome")
	@Size(max=100)
	private String nome;
	
	@ManyToMany(cascade= {CascadeType.ALL})
	@JoinTable(name="campeonato_grupo", 
		joinColumns= @JoinColumn(name="id_campeonato"),
		inverseJoinColumns = @JoinColumn(name="id_grupo")
	)
	private List<Grupo> grupo;

}

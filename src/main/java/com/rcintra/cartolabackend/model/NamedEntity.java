package com.rcintra.cartolabackend.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class NamedEntity extends BaseEntity {

	private static final long serialVersionUID = 7691532837346927715L;
	
	
	@Column(name = "nome")
    private String nome;

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return this.getNome();
    }

}

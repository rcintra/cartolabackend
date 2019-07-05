package com.rcintra.cartolabackend.grupo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.rcintra.cartolabackend.domain.Grupo;

@XmlRootElement
public class Grupos {
	
	private List<Grupo> grupos;

	@XmlElement
	public List<Grupo> getGrupoList() {
		if (grupos == null) {
			grupos = new ArrayList<>();
		}
		return grupos;
	}
}

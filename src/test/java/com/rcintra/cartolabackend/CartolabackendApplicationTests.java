package com.rcintra.cartolabackend;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rcintra.cartolabackend.domain.Grupo;
import com.rcintra.cartolabackend.repository.GrupoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartolabackendApplicationTests {
	
	@Autowired
	private GrupoRepository grupoRepository;

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void incluirGrupos() {
		grupoRepository.save(new Grupo("Grupo 1"));
		grupoRepository.save(new Grupo("Grupo 2"));
		grupoRepository.save(new Grupo("Grupo 3"));
		grupoRepository.save(new Grupo("Grupo 4"));
	}

}

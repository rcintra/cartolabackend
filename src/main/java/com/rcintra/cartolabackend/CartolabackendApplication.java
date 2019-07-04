package com.rcintra.cartolabackend;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.rcintra.cartolabackend.domain.Grupo;
import com.rcintra.cartolabackend.repository.GrupoRepository;

@SpringBootApplication
public class CartolabackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(CartolabackendApplication.class, args);
	}
	
	/*@Bean
	ApplicationRunner applicationRunner(GrupoRepository grupoRepository) {
		return args -> {
			grupoRepository.save(new Grupo("Grupo 1"));
			grupoRepository.save(new Grupo("Grupo 2"));
			grupoRepository.save(new Grupo("Grupo 3"));
			grupoRepository.save(new Grupo("Grupo 4"));
		};
	}*/

}

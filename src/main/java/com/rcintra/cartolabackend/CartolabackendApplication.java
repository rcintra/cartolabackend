package com.rcintra.cartolabackend;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rcintra.cartolabackend.model.Time;
import com.rcintra.cartolabackend.model.json.TimeDeserializer;
import com.rcintra.cartolabackend.service.TimeService;

@SpringBootApplication
public class CartolabackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(CartolabackendApplication.class, args);
	}
	
	@Bean
	ApplicationRunner applicationRunner(TimeService timeService) {
		return args -> {
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<TimeDeserializer>> typeReference = new TypeReference<List<TimeDeserializer>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/times.json");
			try {
				List<TimeDeserializer> times = mapper.readValue(inputStream, typeReference);
				timeService.save(times.stream().map(t -> new Time(t)).collect(Collectors.toList()));
				System.out.println("Times Saved!");
			} catch (IOException e) {
				System.out.println("Unable to save times: " + e.getMessage());
			}
		};
	}

}

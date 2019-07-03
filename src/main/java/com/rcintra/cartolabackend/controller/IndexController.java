package com.rcintra.cartolabackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

	@GetMapping("/")
	String hello() {
		return "Hello Cartola BackEnd";
	}
}

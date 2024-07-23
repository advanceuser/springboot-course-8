package com.luis.curso.springboot.app.aop.controllers;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luis.curso.springboot.app.aop.services.GreetingService;

@RestController
@RequestMapping("/app")
public class GreetingController {

	@Autowired
	private GreetingService greetingService;

	@GetMapping("/greeting")
	public ResponseEntity<?> greeting() {
		return ResponseEntity
				.ok(Collections.singletonMap("greeting", greetingService.sayHello("Pepe", "Hola que tal")));
	}

	@GetMapping("/greeting-error")
	public ResponseEntity<?> greetingError() {
		return ResponseEntity
				.ok(Collections.singletonMap("greeting", greetingService.sayHelloError("Pepe", "Hola que tal")));
	}
}

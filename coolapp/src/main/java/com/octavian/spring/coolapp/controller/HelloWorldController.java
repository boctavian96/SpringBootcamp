package com.octavian.spring.coolapp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@Value("${owner.name}")
	String onwerName;

	@GetMapping(value = "/")
	public String helloWorld() {
		return "Hello Tavee!";
	}

	@GetMapping(value = "/owner")
	public String showOnwner() {
		return onwerName;
	}
}

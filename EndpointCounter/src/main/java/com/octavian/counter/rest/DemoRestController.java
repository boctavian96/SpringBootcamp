package com.octavian.counter.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoRestController {

	@GetMapping("hello")
	public String helloUser() {
		return "Hello my man!";
	}

	@GetMapping("bye")
	public String byeUser() {
		return "Bye bye my man!";
	}
}

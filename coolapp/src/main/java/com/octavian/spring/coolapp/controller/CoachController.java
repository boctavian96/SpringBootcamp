package com.octavian.spring.coolapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.octavian.spring.coolapp.model.Coach;

@RestController()
public class CoachController {

	Coach coach;

	// Constructor Injection;
	@Autowired
	CoachController(@Qualifier("footballCoach") Coach theCoach) {
		this.coach = theCoach;
	}

	@GetMapping("/coach/getWorkout")
	public String getWorkout() {
		return coach.getWorkout();
	}
}

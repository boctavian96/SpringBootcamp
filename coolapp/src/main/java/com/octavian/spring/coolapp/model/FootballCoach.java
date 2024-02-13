package com.octavian.spring.coolapp.model;

import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach {

	@Override
	public String getWorkout() {
		return "Flotari";
	}

}

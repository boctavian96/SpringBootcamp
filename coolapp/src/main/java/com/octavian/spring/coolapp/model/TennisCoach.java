package com.octavian.spring.coolapp.model;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{

	@Override
	public String getWorkout() {
		return "Abdomene";
	}

}

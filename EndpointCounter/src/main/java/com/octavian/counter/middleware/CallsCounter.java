package com.octavian.counter.middleware;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class CallsCounter {

	Logger logger = LoggerFactory.getLogger(getClass());

	public void idk() {
		logger.info("Middleware started");
		System.out.println("Middleware started");
	}
}

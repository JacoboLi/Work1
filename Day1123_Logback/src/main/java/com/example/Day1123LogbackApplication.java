package com.example;

import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Day1123LogbackApplication {
	
	private static final Logger logger = LoggerFactory
			.getLogger(Day1123LogbackApplication.class);
	
	@PostConstruct
	public void logSomething() {
		logger.debug("Jacob Debug Message");
		logger.info("Jacob Info Message");
		logger.trace("Jacob Trace Message");
		logger.error("Jacob Error Message");
		logger.warn("Jacob Warn Message");
	}

	public static void main(String[] args) {
		SpringApplication.run(Day1123LogbackApplication.class, args);
	}
}

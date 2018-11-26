package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

	private static final Logger logger = LoggerFactory
					.getLogger(Hello.class);


	@RequestMapping("/hello")
	public String index() {
		
		logger.debug("Hello Debug Message");
		logger.info("Hello Info Message");
		logger.trace("Hello trace Message");
		logger.error("Hello error Message");
		logger.warn("Hello warn Message");
		return "Hello World";
	}
	
}

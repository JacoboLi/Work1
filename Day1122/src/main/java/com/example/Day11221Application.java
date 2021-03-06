package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Day11221Application {
	
	@RequestMapping("/hello")
	public String hello() {
		return "hello ";
	}

	public static void main(String[] args) {
		SpringApplication.run(Day11221Application.class, args);
	}
}

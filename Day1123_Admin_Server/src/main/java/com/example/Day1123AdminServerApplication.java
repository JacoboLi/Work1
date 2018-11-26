package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import de.codecentric.boot.admin.config.EnableAdminServer;

@SpringBootApplication
@Configuration
@EnableAdminServer
@EnableAutoConfiguration
public class Day1123AdminServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Day1123AdminServerApplication.class, args);
	}
}

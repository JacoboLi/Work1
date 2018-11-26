package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.profile.GoodBye;
import com.example.profile.Message;

@SpringBootApplication
public class Day1123ProfileApplication implements CommandLineRunner {

	
	@Autowired
	private Message helloWorld;

	
	@Override
	public void run(String... args) {
		System.out.println(this.helloWorld.getMessage());
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Day1123ProfileApplication.class, args);
	}
}

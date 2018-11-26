package com.example;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.ServletRequestHandledEvent;


@SpringBootApplication
//@RestController
public class Day1122Application {
	public static void main(String[] args) {
		SpringApplication.run(Day1122Application.class, args);
	}
	
	@Bean
	public static CommandLineRunner testA() {
		CommandLineRunner runner =new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				
				System.out.println("The testA runner start to init");
			}
		};
		return runner;
	}
	
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args ->{
			System.out.println("list:bean" + ctx.getBeanDefinitionCount());
			
//			String[] beanNames = ctx.getBeanDefinitionNames();
//			Arrays.sort(beanNames);
//			for (String string : beanNames) {
//				System.out.println(beanNames);
//			}
		};
	}
	
	@Bean
	public ApplicationRunner appRunner() {
		return args ->{
			System.out.println();
			System.out.println("Application Runner: ");
			for (String opt : args.getOptionNames()) {
				System.out.println(opt);
				System.out.println("-->");
				System.out.println(args.getOptionValues(opt).stream().collect(Collectors.joining(opt)));
//				String.join(",", args.getOptionValues(opt));
			}
		};
	}
	
	
	public ApplicationListener<ApplicationEvent> helloListenner(){
		final String HELLO_URL = "/hello";
		return (ApplicationEvent Event) ->{
			ServletRequestHandledEvent e = (ServletRequestHandledEvent) Event;
			if (e.getRequestUrl().equals(HELLO_URL)) {
				System.out.println("visit hello");
			}
		};
	}
}
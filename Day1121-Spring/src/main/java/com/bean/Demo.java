package com.bean;

import org.springframework.stereotype.Service;

@Service
public class Demo {
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Demo(String name) {
		super();
		this.name = name;
	}

	public Demo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		
		System.out.println("Demo [name=" + name + "]");
		return "Demo [name=" + name + "]";
	}
	

}

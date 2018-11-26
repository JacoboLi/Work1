package com.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class YetAnotherBean {
	@Value("123")
	private String name = "YetAnotherBean";

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}

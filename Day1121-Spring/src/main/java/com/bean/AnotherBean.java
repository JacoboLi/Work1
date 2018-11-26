package com.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AnotherBean {

	private String name = "AnotherBean";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public ExampleBean getExampleBean() {
		return getExampleBean();
	}

}

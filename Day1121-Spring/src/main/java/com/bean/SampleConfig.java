package com.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class SampleConfig {
	
	@Bean
	public ExampleBean exampleBean() {
		
		ExampleBean exampleBean = new ExampleBean();
		exampleBean.setBeanOne(anotherBean());
		exampleBean.setBeanTwo(yetAnotherBean());
		return exampleBean;
	}
	
	private AnotherBean anotherBean() {
		AnotherBean anotherBean = new AnotherBean();
		anotherBean.setName("i ' m anotherBean");
		return anotherBean;
	}

	private YetAnotherBean yetAnotherBean() {
		YetAnotherBean yetAnotherBean = new YetAnotherBean();
		yetAnotherBean.setName("i ' m yetAnotherBean");
		return yetAnotherBean;
	}
	
	

}

package com.example.profile;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"GoodBye"})
public class GoodBye implements Message {
	
	@Value("${name:World}")
	private String name;
	
	@Value("${age:55}")
	private String age;

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Hello " + this.name + ":" + this.age;
	}
	

}

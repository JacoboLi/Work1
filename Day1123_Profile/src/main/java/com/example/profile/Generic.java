package com.example.profile;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"Generic"})
public class Generic implements Message {
	
	@Value("${name:World}")
	private String name;
	
	@Value("${hello:hello}")
	private String hello;

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return this.hello + " " + this.name;
	}

}

package com.demo;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ApplicationContextTest {

	@Test
	public void test() {
		ApplicationContext context = new FileSystemXmlApplicationContext("classpath:beans.xml");
	}

}

package com.demo;

import static org.junit.Assert.*;

import javax.naming.InitialContext;

import org.junit.Before;
import org.junit.Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.Demo;

public class BensXmlTest {
	
	private AbstractApplicationContext context;
	
	@Before
	public void InitialContext() {
		context = new ClassPathXmlApplicationContext("beans.xml");
		
		
		int count = context.getBeanDefinitionCount();
		System.out.println("bean的个数:"+ count);
		String[] names = context.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(name+ "");
			Object bean = context.getBean(name);
			System.out.println(bean.getClass());
		}
		
	}

	@Test
	public void test() {
		context.getBean("demo",Demo.class).toString();
	}
//	
//	@Test
//	public void testLifeBean() {
//		
//	}

}

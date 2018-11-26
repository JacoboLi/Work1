package com.demo;

import static org.junit.Assert.*;

import javax.naming.InitialContext;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bean.Demo;
import com.bean.ExampleBean;

public class AnnotationTest {
	private AnnotationConfigApplicationContext context;
	
	@Before
	public void InitialContext() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.bean");
		context.refresh();
		context.registerShutdownHook();
		
		int count = context.getBeanDefinitionCount();
		System.out.println("bean的个数:"+ count);
		String[] names = context.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(name+ "--->");
			Object bean = context.getBean(name);
			System.out.println(bean.getClass());
		}
		
	}
	
	
	@Test
	public void test() {
		context.getBean("demo",Demo.class).toString();
	}
	
//	@Test
//	public void testExampleBean() {
//		System.out.println(context.getBean(ExampleBean.class));
//		
//	}
	
	

}

package com.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext context = new FileSystemXmlApplicationContext("classpath:beans.xml");
		
		int count = context.getBeanDefinitionCount();
		System.out.println("bean的个数:"+ count);
		String[] names = context.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(name+ "");
			Object bean = context.getBean(name);
			System.out.println(bean.getClass());
		}
		
		context.getBean("demo",Demo.class).toString();

	}

}

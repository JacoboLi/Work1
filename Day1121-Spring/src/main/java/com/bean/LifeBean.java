package com.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class LifeBean implements InitializingBean , DisposableBean {
	
	public void start() {
		System.out.println("111");
	}
	
	public void stop() {
		System.out.println("5222");
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("3333");		
	}

	public void destroy() throws Exception {
		System.out.println("444");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

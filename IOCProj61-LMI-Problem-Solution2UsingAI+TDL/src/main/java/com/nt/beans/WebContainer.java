package com.nt.beans;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class WebContainer implements ApplicationContextAware {
	
	private String beanId;
	private ApplicationContext ctx=null;
	
	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		System.out.println("WebContainer.setApplicationContext()");
		this.ctx=ctx;
		
	}
	


	public WebContainer(String beanId) {
		System.out.println("WebContainer::1-param constructor ");
	
			this.beanId=beanId;
	}
	
	public void  processRequest(String data) {
	
		RequestHandler rh=null; 
		System.out.println("WebContainer recived request having data::  "+data +"   for processing-->"+this.hashCode());
			  //perform Dependency lookup to get Dependent object
		  rh=ctx.getBean(beanId,RequestHandler.class);
		  		rh.handle(data);
		
	}

	
}

package com.nt.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class WebContainer {
	
	private String beanId;

	public WebContainer(String beanId) {
		System.out.println("WebContainer::1-param constructor ");
	
			this.beanId=beanId;
	}
	
	public void  processRequest(String data) {
		ApplicationContext ctx=null;
		RequestHandler rh=null; 
		System.out.println("WebContainer recived request having data::  "+data +"   for processing-->"+this.hashCode());
		//Extra Container for dependency lookup
		  ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		  //perform Dependency lookup to get Dependent object
		  rh=ctx.getBean(beanId,RequestHandler.class);
		  		rh.handle(data);
		
	}
	

}

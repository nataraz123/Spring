package com.nt.beans;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public abstract class WebContainer{
	
	public abstract RequestHandler getHandler();
	
	public void  processRequest(String data) {
	
		RequestHandler rh=null; 
		System.out.println("WebContainer recived request having data::  "+data +"   for processing-->"+this.hashCode());
		  //get Depedent Bean class object
		rh=getHandler();
		//use Dependent Bean
		  		rh.handle(data);
		
	}

	
}

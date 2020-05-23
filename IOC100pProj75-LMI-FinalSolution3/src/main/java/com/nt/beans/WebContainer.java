package com.nt.beans;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component("container")
public abstract class WebContainer{
	
	//@Lookup(value="handler")
	@Lookup
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

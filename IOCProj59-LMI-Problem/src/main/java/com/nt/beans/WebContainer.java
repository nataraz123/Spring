package com.nt.beans;

public class WebContainer {
	private RequestHandler rh;

	public WebContainer(RequestHandler rh) {
		System.out.println("WebContainer::1-param constructor ");
			this.rh = rh;
	}
	
	public void  processRequest(String data) {
		System.out.println("WebContainer recived request having data::  "+data +"   for processing-->"+this.hashCode());
		rh.handle(data);
		
	}
	

}

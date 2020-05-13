package com.nt.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("handler")
@Scope("prototype")
public class RequestHandler {
	private static int count;
	
	public RequestHandler() {
		count++;
		System.out.println("RequestHandler::0-param  constructor::" +count);
	}
	
	
	public   void  handle(String data) {
		System.out.println("handling request using object ::"+count + "having data :::"+data +"-->"+this.hashCode());
	}

}

package com.nt.test;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.MobilePhone;

public class AwareInjectionBasedDependencyLookupTest {

	public static void main(String[] args) {
	  ApplicationContext ctx=null;
		MobilePhone phone=null;
	//create IOC container
		System.out.println("1st IOC container");
	    ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		 //get Target bean class object
		 phone=ctx.getBean("phone",MobilePhone.class);
		 System.out.println(".........................................");
		 //invoke methods
		 phone.batteryCharging();
		 
		 System.out.println("...............other .bmethods-----");
		 phone.entertainment();
		 phone.calls();
		 phone.gaming();
		 phone.shopping();
		
		
	}

}

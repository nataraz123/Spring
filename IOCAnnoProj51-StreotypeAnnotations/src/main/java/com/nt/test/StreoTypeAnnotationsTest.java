package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.nt.beans.Vechicle;




public class StreoTypeAnnotationsTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		Vechicle vehicle=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get  Bean
		vehicle=ctx.getBean("vechicle",Vechicle.class);
		//invoke method
		vehicle.jounery("hyd","goa");
		
		//close container
		((AbstractApplicationContext) ctx).close();
		
				

	}//main

}//class

package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.WebContainer;

public class LMISolutionTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		WebContainer container=null;
		//create  ApplicationContext container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Target Bean class object
		container=ctx.getBean("container",WebContainer.class);
		System.out.println(container.getClass()+"  "+container.getClass().getSuperclass());
		//invoke methods
		container.processRequest("corona patient");
		System.out.println("==========================");
		container.processRequest("corona treatement");
		System.out.println("=========================");
		container.processRequest("corona hospital");
		
		System.out.println("_____________________________________________");
		System.out.println("______________________________________________");
		//get Target Bean class object
		container=ctx.getBean("container",WebContainer.class);
		
		container.processRequest("corona patient1");
		System.out.println("==========================");
		container.processRequest("corona treatement1");
		System.out.println("=========================");
		container.processRequest("corona hospital1");
		
		//close container
		((AbstractApplicationContext) ctx).close();

	}

}

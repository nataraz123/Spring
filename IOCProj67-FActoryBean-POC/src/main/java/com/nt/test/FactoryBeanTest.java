package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.ScheduleRemainder;

public class FactoryBeanTest {
	public static void main(String[] args) {
		ApplicationContext ctx=null;
		ScheduleRemainder remainder=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		System.out.println("...................................");
		//get Bean target bean class object
		remainder=ctx.getBean("remainder",ScheduleRemainder.class);
		System.out.println("............................");
		System.out.println(remainder.remainderOfTheDay());
		System.out.println(".............................................");
		
		Object obj=ctx.getBean("dfb",Object.class);
		System.out.println(obj.getClass());
		
		//close container
		((AbstractApplicationContext) ctx).close();
		
	}

}

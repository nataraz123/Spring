package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.nt.beans.PersonProfile;

public class NullInjectionTest1 {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		PersonProfile profile1=null,profile2=null,profile3=null,profile4=null,profile5=null;
		//create IOC container of type "AC"
		//ctx=new FileSystemXmlApplicationContext("src/main/java/com/nt/cfgs/applicationContext.xml");
		 ctx=new  ClassPathXmlApplicationContext("applicationContext.xml");
		
			/*	//get Bean
				profile1=ctx.getBean("rajaProfile",PersonProfile.class);
				System.out.println(profile1);
				System.out.println(".....................................");
				
				profile2=ctx.getBean("raniProfile",PersonProfile.class);
				System.out.println(profile2);
				System.out.println(".....................................");
				*/
		
		
		((AbstractApplicationContext) ctx).close();

	}

}

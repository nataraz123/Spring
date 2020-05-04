package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.PersonProfile;

public class RequiredAnnoTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		PersonProfile pp=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get  bean
		pp=ctx.getBean("pp",PersonProfile.class);
		System.out.println(pp);
		
		//close container
		((AbstractApplicationContext) ctx).close();

	}

}

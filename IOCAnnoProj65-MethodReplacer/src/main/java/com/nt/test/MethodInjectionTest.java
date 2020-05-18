package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.BankService;

public class MethodInjectionTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		BankService service=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Target bean class object
		service=ctx.getBean("bank",BankService.class);
		System.out.println(service.getClass()+"------->"+service.getClass().getSuperclass());
		//invoke b.methods
		System.out.println(service.calcIntrestAmount(100000,12));
		
		//close container
		((AbstractApplicationContext) ctx).close();

	}

}

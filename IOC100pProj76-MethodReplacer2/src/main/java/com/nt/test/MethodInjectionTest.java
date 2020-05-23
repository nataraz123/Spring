package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.BankService;
import com.nt.config.AppConfig;

public class MethodInjectionTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		BankService service=null;
		//create IOC container
		ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		//get Target bean class object
		service=ctx.getBean("bank",BankService.class);
		System.out.println(service.getClass()+"------->"+service.getClass().getSuperclass());
		//invoke b.methods
		System.out.println(service.calcIntrestAmount(100000,12));
		
		//close container
		((AbstractApplicationContext) ctx).close();

	}

}

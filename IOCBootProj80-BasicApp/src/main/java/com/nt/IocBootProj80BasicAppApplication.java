package com.nt;

import java.io.PrintStream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.beans.WishMessageGenerator;

@SpringBootApplication
public class IocBootProj80BasicAppApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		WishMessageGenerator generator=null;
		String msg=null;
		System.out.println("IocBootProj80BasicAppApplication.main()");
		//get IOC container
		ctx=SpringApplication.run(IocBootProj80BasicAppApplication.class, args);
		System.out.println(ctx.getClass());
		//get Target Bean class object
		generator=ctx.getBean("wmg",WishMessageGenerator.class);
		//invoke b.method
		msg=generator.generateWishMessage("raja");
		System.out.println("Result is :::"+msg);
		
		//close container
		((ConfigurableApplicationContext) ctx).close();
		
	}//main

}//class

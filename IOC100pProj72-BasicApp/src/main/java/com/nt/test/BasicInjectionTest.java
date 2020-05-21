package com.nt.test;

import java.util.Calendar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.nt.beans.WishMessageGenerator;
import com.nt.config.AppConfig;

public class BasicInjectionTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		WishMessageGenerator generator=null;
		//create IOC container
		ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println("........................................");
		//get Bean
		generator=ctx.getBean("wmg",WishMessageGenerator.class);
		System.out.println("...........................................");
		//Calendar cal=ctx.getBean("createCalendar",Calendar.class);
		Calendar cal=ctx.getBean("cal",Calendar.class);
		System.out.println(cal);
		//invoke method
		//System.out.println(generator.generateWishMessage("raja"));
		System.out.println("........................................................");
		//close container
		((AbstractApplicationContext) ctx).close();

	}

}

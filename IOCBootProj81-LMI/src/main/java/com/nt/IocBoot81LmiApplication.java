package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.beans.WebContainer;

@SpringBootApplication
public class IocBoot81LmiApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		WebContainer container=null;
		//get IOC container
		ctx=SpringApplication.run(IocBoot81LmiApplication.class, args);
		//get Bean 
		container=ctx.getBean("container",WebContainer.class);
		//invoke methods
		container.processRequest("ameerpet");
		container.processRequest("charminar");
		
		//close container
		((ConfigurableApplicationContext) ctx).close();
		
		
	}

}

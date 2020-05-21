package com.nt.config;

import java.util.Calendar;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@ComponentScan(basePackages = "com.nt.beans")
public class AppConfig {
	
	static {
		System.out.println("AppConfig::static block)");
	}
	
	public AppConfig() {
		System.out.println("AppConfig:: 0-param constructor");
	}
	
	@Bean(name="cal")
	//@Bean
	@Lazy
	public Calendar createCalendar() {
		System.out.println("AppConfig.createCalendar()");
		return Calendar.getInstance();
		
	}

}

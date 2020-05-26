package com.nt.config;

import java.util.Calendar;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	
	@Bean(name="cal")
	public  Calendar createCalendar() {
		Calendar cal=null;
		System.out.println("AppConfig.createCalendar()");
		
		cal=Calendar.getInstance();
		return cal;
	}

}

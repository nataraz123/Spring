package com.nt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.nt.controller")
public class WebMVCAppConfig {
	
	public WebMVCAppConfig() {
		System.out.println("WebMVCAppConfig:: 0-param constructor");
	}
	
	@Bean
	public  InternalResourceViewResolver   createIRVR() {
		System.out.println("WebMVCAppConfig.createIRVR()");
		 InternalResourceViewResolver  resolver=null;
		 resolver=new InternalResourceViewResolver();
		 resolver.setPrefix("/WEB-INF/pages/");
		 resolver.setSuffix(".jsp");
		 return resolver;
	}

}

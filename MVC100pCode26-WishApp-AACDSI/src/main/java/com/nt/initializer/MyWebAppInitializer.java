package com.nt.initializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.nt.config.RootAppConfig;
import com.nt.config.WebMVCAppConfig;

public class MyWebAppInitializer  extends AbstractAnnotationConfigDispatcherServletInitializer {

	public MyWebAppInitializer() {
		System.out.println("MyWebAppInitializer::0-param constructor");
		}
	
	@Override
	public Class<?>[] getRootConfigClasses() {
		System.out.println("MyWebAppInitializer.getRootConfigClasses()");
		return new Class[] {RootAppConfig.class};
	}

	@Override
	public Class<?>[] getServletConfigClasses() {
		System.out.println("MyWebAppInitializer.getServletConfigClasses()");
		return new Class[] {WebMVCAppConfig.class};
	}

	@Override
	public String[] getServletMappings() {
		return new String[] {"*.htm"};
	}
	
	

}

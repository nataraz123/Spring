package com.nt.initializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.nt.config.RootAppConfig;
import com.nt.config.WebMVCAppConfig;

public class MyWebAppInitializer implements WebApplicationInitializer {
	
	  public MyWebAppInitializer() {
		System.out.println("MyWebAppInitializer:: 0-param constructor");
	}

	@Override
	public void onStartup(ServletContext sc) throws ServletException {
		System.out.println("MyWebAppInitializer.onStartup(-)");
		  AnnotationConfigWebApplicationContext  parentCtx=null,childCtx=null;
		  ContextLoaderListener listener=null;
		  DispatcherServlet servlet=null;
		  ServletRegistration.Dynamic dynamic=null;
		  //create  parent container
		  parentCtx=new AnnotationConfigWebApplicationContext();
		  parentCtx.register(RootAppConfig.class);
		  //create ContextLoaderListener
		  listener=new ContextLoaderListener(parentCtx);
		  //register Listener with ServletContainer
		  sc.addListener(listener);
		  
		  //create ChildContainer
		  childCtx=new AnnotationConfigWebApplicationContext();
		  childCtx.register(WebMVCAppConfig.class);
		  //create create DispatcherServlet
		  servlet=new DispatcherServlet(childCtx);
		  //register DispatcherServlet with ServletContainer
		  dynamic=sc.addServlet("ds", servlet);
		  dynamic.setLoadOnStartup(2);
		  dynamic.addMapping("*.htm");
		  
		  
	}

}

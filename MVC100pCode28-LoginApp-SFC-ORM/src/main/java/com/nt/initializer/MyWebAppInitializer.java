package com.nt.initializer;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.nt.config.RootAppConfig;
import com.nt.config.WebMVCAppConfig;

public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	public Class<?>[] getRootConfigClasses() {
		
		return new Class[] {RootAppConfig.class};
	}

	@Override
	public Class<?>[] getServletConfigClasses() {
	
		return new Class[] {WebMVCAppConfig.class};
	}

	@Override
	public String[] getServletMappings() {
		
		return new String[] {"*.htm"};
	}

}

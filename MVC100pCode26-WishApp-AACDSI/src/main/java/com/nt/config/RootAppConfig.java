package com.nt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(ServiceConfig.class)
public class RootAppConfig {
    public RootAppConfig() {
		System.out.println("RootAppConfig:: 0-param constructor");
	}
}

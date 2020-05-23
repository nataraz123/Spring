package com.nt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@Import(value= {ServiceConfig.class,PersistenceConfig.class})
public class BusinessAppConfig {
	
	
	

}

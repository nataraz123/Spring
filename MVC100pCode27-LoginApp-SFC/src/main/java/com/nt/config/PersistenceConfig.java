package com.nt.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jndi.JndiObjectFactoryBean;

@Configuration
@ComponentScan(basePackages = "com.nt.dao")
public class PersistenceConfig {
	
	@Bean(name="ds")
	public  JndiObjectFactoryBean  createJOFB() {
		JndiObjectFactoryBean jofb=null;
		jofb=new JndiObjectFactoryBean();
		jofb.setJndiName("java:/comp/env/DsJndi");
		return jofb;
	}
	
	@Bean(name="jt")
	public   JdbcTemplate  createJT() {
		 JdbcTemplate jt=null;
		 jt=new JdbcTemplate((DataSource) createJOFB().getObject());
		 return jt;
	}

}

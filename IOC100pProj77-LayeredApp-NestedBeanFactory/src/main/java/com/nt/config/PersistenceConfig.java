package com.nt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.lang.Nullable;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = "com.nt.dao")
@PropertySource("com/nt/commons/jdbc.properties")
public class PersistenceConfig {
	@Value("${jdbc.driver}")
	@Nullable
	private String driver;
	
	@Value("${jdbc.url}")
	@Nullable
	private String url;
	
	@Value("${jdbc.username}")
	@Nullable
	private String username;
	
	@Value("${jdbc.pwd}")
	@Nullable
	private String pwd;
	
	@Value("${jdbc.pool.minidle}")
	@Nullable
	private int minSize;
	
	@Value("${jdbc.pool.maxsize}")
	@Nullable
	private int maxSize;
	
	@Value("${os.name}")
	@Nullable
	private String os;
	
	@Bean(name="hkDs")
	public HikariDataSource createHKDs() {
		HikariDataSource hkDs=null;
		hkDs=new HikariDataSource();
		hkDs.setDriverClassName(driver);
		hkDs.setJdbcUrl(url);
		hkDs.setUsername(username);
		hkDs.setPassword(pwd);
		hkDs.setMinimumIdle(minSize);
		hkDs.setMaximumPoolSize(maxSize);
		System.out.println("os name ::"+os);
		return hkDs;
		
	}
	
	/*@Autowired
	private Environment  env;
	
	@Bean(name="hkDs")
	public HikariDataSource createHKDs() {
		HikariDataSource hkDs=null;
		hkDs=new HikariDataSource();
		hkDs.setDriverClassName(env.getRequiredProperty("jdbc.driver"));
		hkDs.setJdbcUrl(env.getRequiredProperty("jdbc.url"));
		hkDs.setUsername(env.getRequiredProperty("jdbc.username"));
		hkDs.setPassword(env.getRequiredProperty("jdbc.pwd"));
		hkDs.setMinimumIdle(Integer.parseInt(env.getRequiredProperty("jdbc.pool.minidle")));
		hkDs.setMaximumPoolSize(Integer.parseInt(env.getProperty("jdbc.pool.maxsize")));
		System.out.println("os name"+env.getProperty("os.name"));
		System.out.println("path value ::"+env.getProperty("path"));
		return hkDs;
		
	}*/

}

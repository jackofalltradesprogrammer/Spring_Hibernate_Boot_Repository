package com.luv2code.springsecurity.demo.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

// Spring MVC app configuration instead of servlet xml configuration
// this tells Spring to use annotations
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.luv2code.springsecurity.demo")
@PropertySource("classpath:persistence-mysql.properties") // maven build compies the files in resources to the classpath
public class DemoAppConfig {
	
	// set up variable to hold the properties, values are automatically added from resources file
	@Autowired
	private Environment env;
	
	// set up a logger for diagnostics
	private Logger logger = Logger.getLogger(getClass().getName());
	
	// define a bean for ViewResolver
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	// define a bean for our security datasource
	
	@Bean
	public DataSource securityDataSource() {
		
		// Create a connection pool
		ComboPooledDataSource securityDataSource = new ComboPooledDataSource();
		
		// set the jdbc driver class
		try {
			securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException exc) {
			// TODO Auto-generated catch block
			throw new RuntimeException(exc);
		}
		
		// log the connection props to make sure they are valid
		logger.info(">>>> jdbc.url=" + env.getProperty("jdbc.url"));
		logger.info(">>>> jdbc.user=" + env.getProperty("jdbc.user"));
		
		
		// set database connection props
		securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		securityDataSource.setUser(env.getProperty("jdbc.user"));
		securityDataSource.setPassword(env.getProperty("jdbc.password"));
		
		// set connection pool props
		securityDataSource.setInitialPoolSize(getintPropery("connection.pool.initialPoolSize"));
		securityDataSource.setMinPoolSize(getintPropery("connection.pool.minPoolSize"));
		securityDataSource.setMaxPoolSize(getintPropery("connection.pool.maxPoolSize"));
		securityDataSource.setMaxIdleTime(getintPropery("connection.pool.maxIdleTime"));
		
		return securityDataSource();
	}
	
	// need a helper method
	// read environment property and conver to int
	private int getintPropery(String propName) {
		
		return Integer.parseInt(env.getProperty(propName));
	}
	
}

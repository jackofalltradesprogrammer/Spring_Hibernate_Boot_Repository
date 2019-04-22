package com.luv2code.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundIWithLoggerDemoApp {
	
	private static Logger myLogger = Logger.getLogger(AroundIWithLoggerDemoApp.class.getName());
	
	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		myLogger.info("\nMain Program: AroundDemoApp");
		String data = theFortuneService.getFortune();
		myLogger.info("\nMy fortune is " + data);
		
		// close the context
		context.close();
	}

}

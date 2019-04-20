package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	// this is where we add all of our related advice for logging
	
	// let's start with a @Before advice
	// here we are using pointCut Expressions where we match any method with the below signature
//	@Before("execution(public void add*())")
	@Before("execution(* add*())")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=====>>> Executing @Before advice on method()");
	}
	
	
}
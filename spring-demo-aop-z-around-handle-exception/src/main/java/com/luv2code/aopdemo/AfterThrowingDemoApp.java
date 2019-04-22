package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		List<Account> theAccounts = null;
		try {
			// add a boolean flag to simulate exceptions
			boolean tripwire = true;
			theAccounts = theAccountDAO.findAccounts(tripwire);
		} catch (Exception exc) {
			// TODO Auto-generated catch block
			System.out.println("\n\n Main Program.... " + exc);
		}
		System.out.println(theAccounts);
		
		// close the context
		context.close();
	}

}

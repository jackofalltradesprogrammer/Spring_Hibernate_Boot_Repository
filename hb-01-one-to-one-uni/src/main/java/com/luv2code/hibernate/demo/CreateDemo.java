package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {

		// create session factory 
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// create the objects
//			Instructor tempInstructor = new Instructor("Char", "Darby", "darby@luv2code.com");
//			InstructorDetail tempInstructorDetail = new InstructorDetail("luv2code.com/youtube", "Luv 2 code");
			
			Instructor tempInstructor = new Instructor("Madhu", "Patel", "madhu@luv2code.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("luv2code.com/youtube", "Guitar");
			
			// associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			session.beginTransaction();
			
			// save the instructor
			// Note: this will Also save the details object
			// because of CascadeType.ALL
			System.out.println("Saving instructor: " + tempInstructor);
			session.save(tempInstructor);
			
			session.getTransaction().commit();
			System.out.println("Done!");
		}catch (Exception e) {
			System.out.println(e);
		}
		finally {
			factory.close();
		}

	}

}

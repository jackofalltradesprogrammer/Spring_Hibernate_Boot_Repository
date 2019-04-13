package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

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
			
			session.beginTransaction();
			
			// get instructor by primary key / id
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			System.out.println("Found Instructor: " + tempInstructor);
			
			// delete the instructor
			if (tempInstructor != null) {
				System.out.println("Deleting... " + tempInstructor);
				
				// Note: will also delete associated "details" ojbect
				// because of CascadeType.ALL
				session.delete(tempInstructor);
			}
			
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

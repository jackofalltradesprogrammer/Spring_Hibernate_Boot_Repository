package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// create the objects
			session.beginTransaction();

			// get the instructor from db, create some courses, add courses to instructor,
			// save the courses
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			System.out.println("Instructor: " + tempInstructor);
			
			// We are calling this method as to avoid error with Lazy Loading when the session is closed
			System.out.println("Courses: " + tempInstructor.getCourses());
			
			session.getTransaction().commit();
			System.out.println("\n\n we are closing the session!!");
			session.close();
			System.out.println("Courses: " + tempInstructor.getCourses());
			System.out.println("Done!");
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
			factory.close();
		}

	}

}

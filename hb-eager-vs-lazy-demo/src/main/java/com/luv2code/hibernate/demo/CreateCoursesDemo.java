package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

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
			Course tempCourse1 = new Course("Air Guitar - The Ultimagte Guide");
			Course tempCourse2 = new Course("The Pinball Masterclass");
			// The courses are being added to the persistent Instance to establish ManyToOne Relationship
			tempInstructor.add(tempCourse1);
			tempInstructor.add(tempCourse2);

			session.save(tempCourse1);
			session.save(tempCourse2);

			session.getTransaction().commit();
			System.out.println("Done!");
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
			factory.close();
		}

	}

}

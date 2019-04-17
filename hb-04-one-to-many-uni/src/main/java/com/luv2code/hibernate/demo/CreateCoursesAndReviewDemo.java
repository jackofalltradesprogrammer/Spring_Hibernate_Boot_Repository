package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;

public class CreateCoursesAndReviewDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// create the objects
			session.beginTransaction();
			
			Course tempCourse = new Course("Pacman - How to Score One Million Points");
			tempCourse.addReview(new Review("Great Course .... loved it"));
			tempCourse.addReview(new Review("Cool Course..."));
			tempCourse.addReview(new Review("What a dumb course!!"));
			
			System.out.println("Saving the course");
			
			session.save(tempCourse);
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

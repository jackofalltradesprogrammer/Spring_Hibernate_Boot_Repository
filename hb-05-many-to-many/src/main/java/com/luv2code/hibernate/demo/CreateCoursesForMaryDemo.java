package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCoursesForMaryDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// create the objects
			session.beginTransaction();
			
			int studentId = 1;
			Student tempStudent = session.get(Student.class, studentId);
			System.out.println("Courses for Mary: " + tempStudent.getCourses());
			
			Course tempCourse1 = new Course("Rubik's Cube - How to Speed Cube");
			Course tempCourse2 = new Course("Atari 2600");
			tempCourse1.addStudent(tempStudent);
			tempCourse2.addStudent(tempStudent);
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

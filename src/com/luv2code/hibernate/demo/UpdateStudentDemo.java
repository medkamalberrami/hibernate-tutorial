package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		//Create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//Create session
		Session session = factory.getCurrentSession();
		
		try {
		
			int studentId = 5;
			
			// now get a new session for start a transaction 
			session = factory.getCurrentSession();
			session.beginTransaction(); 
			
			
			//Retrieve the student based en id : primary key
			
			System.out.println("Getting student by id : " +  studentId);
			
			Student myStudent = session.get(Student.class, studentId );
			System.out.println("Getting my student" + myStudent);
			
			
			// update student 
			
			System.out.println("Updating student ...");
			
			myStudent.setLastName("scooby");
			
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done !!");
			
			
			//new code
			//update email for all students

			session = factory.getCurrentSession();
			session.beginTransaction(); 
			
			System.out.println("pdate email for all students");
			
			session.createQuery("update Student set email='ben@gmail.com'").executeUpdate();
			
			//commit the transaction
			session.getTransaction().commit();

			System.out.println("Done !!");

			
			
		
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			factory.close();
		}
	}

}

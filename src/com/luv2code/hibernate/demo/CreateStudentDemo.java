package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		//Create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//Create session
		Session session = factory.getCurrentSession();
		
		try {
			// use the session object to save java object
			
			// create a student object
			System.out.println("Create new student object ...");
			Student tempStudent = new Student("med kamal", "berrami", "medkamal@gmail.com");
			
			//start a transaction
			session.beginTransaction();		
			
			//save the student object
			System.out.println("Saving the student ...");
			session.save(tempStudent);
			
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

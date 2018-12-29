package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

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
					
					// create three student objects
					System.out.println("Create 3 student objects ...");
					Student tempStudent1 = new Student("John", "Wall", "luv2code@gmail.com");
					Student tempStudent2 = new Student("Mary", "Public", "mary@gmail.com");
					Student tempStudent3 = new Student("Bonita", "AppleBaum", "bonita@gmail.com");

					//start a transaction
					session.beginTransaction();		
					
					//save the student object
					System.out.println("Saving the students ...");
					session.save(tempStudent1);
					session.save(tempStudent2);
					session.save(tempStudent3);

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

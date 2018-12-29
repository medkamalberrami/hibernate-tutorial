package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

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
			Student tempStudent = new Student("soul", "nafy", "nafy@gmail.com");
			
			//start a transaction
			session.beginTransaction();		
			
			//save the student object
			System.out.println("Saving the student ...");
			System.out.println(tempStudent);
			session.save(tempStudent);
			
			//commit the transaction
			session.getTransaction().commit();
			
			//my new code 
			
			
			//find out the student id bye primary key
			
			System.out.println("Generated id student" + tempStudent.getIdStudent());
			
			// now get a new session for start a transaction 
			session = factory.getCurrentSession();
			session.beginTransaction(); 
			
			
			//Retrieve the student based en id : primary key
			
			System.out.println("Getting student by id : " + tempStudent.getIdStudent());
			
			Student myStudent = session.get(Student.class, tempStudent.getIdStudent());
			System.out.println("Getting my student" + myStudent);
			
			
			//commit the transaction
			session.getTransaction().begin();

			System.out.println("Done !!");
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			factory.close();
		}
	}

}

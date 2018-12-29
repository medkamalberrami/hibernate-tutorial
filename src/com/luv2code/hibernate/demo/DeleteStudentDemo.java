 package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

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
			
			//delete student 
			System.out.println("Deleting student : " + myStudent);
			 session.delete(myStudent);
			 
			 
			 //delete student id 4
			System.out.println("Deleting student id :  4");
			session.createQuery("delete Student where idStudent=4").executeUpdate();
			
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

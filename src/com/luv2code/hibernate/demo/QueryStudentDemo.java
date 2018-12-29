package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;


public class QueryStudentDemo {

	public static void main(String[] args) {

		//Create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//Create session
		Session session = factory.getCurrentSession();
		
		try {			
			//start a transaction
			session.beginTransaction();		
			

			//query the students 
			List<Student> listStudent  = session.createQuery("from Student").list();
			
			
			//display the student
			displayStudents(listStudent);
			
			// query student where lastname equal wall
			listStudent = session.createQuery("from Student s where s.lastName ='Wall'").list();
			
			//display the student 
			System.out.println("sudent who's lastname eqal wall");
			displayStudents(listStudent);
			
			
			
			// students : lastName equal wall or berrami
			listStudent = session.createQuery("from Student s where s.lastName ='Wall' or s.lastName='berrami'").list();

			
			//display the student 
			System.out.println("students : lastName equal wall or berrami");
			displayStudents(listStudent);

			
			//query student mail like bonita
			listStudent = session.createQuery("from Student s where s.email like '%boni%' ").list();

			
			//display the student 
			System.out.println("students : mail like bonita");
			displayStudents(listStudent);
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done !!");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> listStudent) {
		for(Student student : listStudent) {
			
			System.out.println(student);
			
		}
	}

}

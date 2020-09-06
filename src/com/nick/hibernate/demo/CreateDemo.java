package com.nick.hibernate.demo;

import java.text.ParseException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nick.hibernate.demo.entity.Instructor;
import com.nick.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) throws ParseException {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();

		try {
			
			session.beginTransaction();
			
			InstructorDetail detail = new InstructorDetail("http://www.siva.com", "sleeping");
			
			Instructor ins = new Instructor("Siva", "Chid", "siva@gmail.com");
			
			ins.setInstructorDetial(detail);
			
			session.save(ins);
			
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
	}

}

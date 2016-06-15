package com.entities;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class Main {
	static Session session = null;
	static Transaction t = null;
	public static void main(String[] args) {
		
		try {
			AnnotationConfiguration cfg = new AnnotationConfiguration();
			cfg.configure("hibernate.cfg.xml");
			
			SessionFactory sessionFactory = cfg.buildSessionFactory();
			session = sessionFactory.openSession();
			t = session.beginTransaction();
			
			
			Student s1 = new Student();
			s1.setName("Rani");
			s1.setMarks(79f);
			
			Address address = new Address();
			address.setState("USA");
			address.setCountry("USA");
			//s1.setAddress(address);
			address.setStudent(s1);
			session.save(s1);
			
			
			Query query  = session.createQuery("from Student");
			List<Student> list = query.list();
			
			for (Student student : list) {
				System.out.println(student);
			}
			t.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if(t.wasCommitted())
				t.rollback();
		}finally{
			session.close();
		}
		
		
	}

}

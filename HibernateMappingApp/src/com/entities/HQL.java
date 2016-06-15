package com.entities;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HQL {

	static Session session = null;
	static Transaction t = null;
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
		t = session.beginTransaction();
		
		Query query = null;
		query = session.createQuery("update Student set name=:i where id=:n");
		query.setParameter("i", "Arjuna");
		query.setParameter("n", 1);
		System.out.println(query.executeUpdate());
		
		query = session.createQuery("delete from Student where id = 1");
		System.out.println("No.of rows deleted:"+query.executeUpdate());
		
		query = session.createQuery("select name from Student");
		List<String> list = query.list();
		for (String student : list) {
			System.out.println(student);
		}
		
		/*query.setFirstResult(2);
		query.setMaxResults(2);
		List<Student> list = query.list();
		for (Student student : list) {
			System.out.println(student);
		}*/
		
		
		t.commit();
		session.close();
	}
}

package com.hib;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
	/*	Department dept = new Department();
		dept.setName("IT");
		session.save(dept);
		
		Department dept2 = new Department();
		dept2.setName("Finance");
		session.save(dept2);
		
		Employee e1 = new Employee("Arjun", 28, 10000, dept);
		Employee e2 = new Employee("Mahesh", 24, 20000, dept);

		
		Employee e3 = new Employee("Anusha", 24, 30000, dept2);
		
		session.save(e1);session.save(e2);
		session.save(e3);*/
		
		Query q = session.createQuery("from Employee");
		List<Employee> list = q.list();
		
		for (Employee emp : list) {
			System.out.println(emp);
		}
		
		transaction.commit();
		session.close();
	}
}

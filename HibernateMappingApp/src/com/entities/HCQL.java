package com.entities;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class HCQL {

	static Session session = null;
	static Transaction t = null;
	public static void main(String[] args) {
		
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
		
		Criteria c = session.createCriteria(Student.class);
		c.setFirstResult(3);
		c.setMaxResults(1);
		List<Student> list = c.list();
		for (Student student : list) {
			System.out.println(student);
		}
		
		c = session.createCriteria(Student.class);
		c.setProjection(Projections.property("name"));
		c.setProjection(Projections.property("marks"));
		c.add(Restrictions.gt("marks", (float)50));
		c.addOrder(Order.desc("id"));
		list = c.list();
		System.out.println(list);
		
		/*Query q = session.getNamedQuery("findstudentWithMoreThan80Marks");
		q.setString("marks", "80");
		List<Student> list = q.list();
		for (Student student : list) {
			System.out.println(student);
		}*/
		
		Employee customer = (Employee)session.load(Employee.class, 1);
		System.out.println(customer);
		session.close();
		Session session2 = sessionFactory.openSession();
		Employee customer2 = (Employee)session2.load(Employee.class, 1);
		System.out.println(customer2);
		session2.close();
		
		
		Session session3 = sessionFactory.openSession();
		Employee customer3 = (Employee)session3.load(Employee.class, 1);
		System.out.println(customer3);
		session3.close();
		System.out.println("Successfully done");
		
	}
}

package com.myhib;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;


public class Main {

	
	public static void main(String[] args) {
		
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");
		

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		Employee e = new Employee();
		e.setId(301);
		e.setName("Hibernate1");
		e.setDesignation("1Development");
		e.setPassword("password");
		e.setPhone(345353);
		e.setEmail("mail@mail.com");
		//session.persist(e);


		//Criteria c = session.createCriteria(Employee.class);
		/*c.add(Restrictions.like("designation", "Lead"));
		c.add(Restrictions.gt("phone", 0));

		Criterion design = Restrictions.like("designation", "Lead");
		Criterion phone = Restrictions.gt("phone", 0);

		//c.add(Restrictions.or(design, phone));
		c.add(Restrictions.and(design, phone));

		c.setFirstResult(5);
		c.setMaxResults(10);
		c.addOrder(Order.asc("name"));
		c.setProjection(Projections.property("name"));
		List<String> list = c.list();
		for (String employee : list) {
			System.out.println(employee);

		}*/
		/*	c.setProjection(Projections.rowCount());
		c.setProjection(Projections.avg("phone"));*/

		session.getTransaction().commit();
		Employee customer = (Employee)session.load(Employee.class, 1);
		System.out.println(customer);
		session.close();
		Session session2 = factory.openSession();
		Employee customer2 = (Employee)session2.load(Employee.class, 1);
		System.out.println(customer2);
		session2.close();
		
		
		Session session3 = factory.openSession();
		Employee customer3 = (Employee)session3.load(Employee.class, 1);
		System.out.println(customer3);
		session3.close();
		System.out.println("Successfully done");
	}
}

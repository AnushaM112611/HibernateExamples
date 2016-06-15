package com.hib;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Part p1 = new Part();
		p1.setName("Engine");
		p1.setManufacturedFrom("Audi");
		
		Part p2 = new Part();
		p2.setName("Bolts");
		p2.setManufacturedFrom("boltMaufacturer");
		
		Part p3 = new Part();
		p3.setName("Lights");
		p3.setManufacturedFrom("Tata");

		List<Part> parts = new ArrayList<>();
		parts.add(p1);
		parts.add(p2);
		parts.add(p3);
		
		Car c1 = new Car();
		c1.setName("Audi");
		c1.setManufacturer("A...");
		c1.setParts(parts);
		
		session.persist(c1);
		
		Query q = session.createQuery("from Car");
		List<Car> list = q.list();
		
		for (Car car : list) {
			System.out.println(car);
		}
		transaction.commit();
		session.close();
	}
}

package com.hib;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

		Map<String, Part> map1 = new HashMap<>();
		map1.put("Interior",p1);
		map1.put("Engine",p2);
		
		Car c1 = new Car();
		c1.setName("Tata");
		c1.setManufacturer("A...");
		c1.setParts(map1);
		
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

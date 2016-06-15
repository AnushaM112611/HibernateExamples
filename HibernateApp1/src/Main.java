import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		org.hibernate.Transaction t = session.beginTransaction();
		Employee e = new Employee();
		e.setId(500);
		e.setName("Divya");
		e.setDesignation("Software Developer");
		e.setPassword("password");
		e.setPhone(345353);
		e.setEmail("divya@mail.com");
		
		session.persist(e);
		t.commit();
		
		Criteria c = session.createCriteria(Employee.class);
		List<Employee> list = c.list();
		for (Employee employee : list) {
			System.out.println(employee);

		}
		
	}
}

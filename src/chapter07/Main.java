package chapter07;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {

		Employee employee = new Employee();
		employee.setName("Bahman");
		employee.setBase_salary(1500000);
		
		Programmer programmer = new Programmer();
		programmer.setName("Mahdi");
		programmer.setBase_salary(1200000);
		programmer.setSkills("Java");
		programmer.setProgrammer_bonus(1500000);
		
		Manager manager = new Manager();
		manager.setName("Fatemeh");
		manager.setBase_salary(1500000);
		manager.setRole("Development Manager");
		manager.setManager_bonus(2000000);
		
		
		SessionFactory sf = new Configuration().configure("ProjectConfig.xml").buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(employee);
		session.save(programmer);
		session.save(manager);
		
		tx.commit();
		session.close();
		
		
	}

}

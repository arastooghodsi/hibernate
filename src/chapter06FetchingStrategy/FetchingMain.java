package chapter06FetchingStrategy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class FetchingMain {

	public static void main(String[] args) {

		Member member = new Member();
		member.setName("Arastoo");
		member.setFamily("Ghodsi");
		
		Address add1 = new Address();
		add1.setCity("Tehran");
		Address add2 = new Address();
		add2.setCity("Hamedan");
		
		member.getAddresses().add(add1);
		member.getAddresses().add(add2);
		
		add1.setMember(member);
		add2.setMember(member);
		
		SessionFactory sf = new Configuration().configure("ProjectConfig.xml").buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		//Save member in DB
//		session.save(member);
		
		//Fetching address of a member
		member = session.get(Member.class, 2);
		
		//Get a data from table needed additional SELECT and it's bad
//		int size = member.getAddresses().size();
//		System.out.println(size);
		
		tx.commit();
		session.close();
		
		//If fetch data after close the session 
//		int size = member.getAddresses().size();
//		System.out.println(size);
//		System.out.println(member.getName());
		
		System.out.println(member.toString());
		
		
		
	}

}

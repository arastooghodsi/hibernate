package chapter09Caching;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure("ProjectConfig.xml").buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		// Save data into DB
//		for(int i = 1; i<=200; i++) {
//			CachingBook cachingBook = new CachingBook();
//			cachingBook.setTitle("book_title" + i);
//			cachingBook.setAuthor("book_author" + i);
//			session.save(cachingBook);
//		}
		
		//First level Cache(Across Session) enable by default
		//Get data with different id
//		CachingBook cachingBook1 = session.get(CachingBook.class, 6);
//		CachingBook cachingBook2 = session.get(CachingBook.class, 7); // In this case we have two select from DB(because we got two id from DB)
		
		//Get data with same id
//		CachingBook cachingBook3 = session.get(CachingBook.class, 6);
//		CachingBook cachingBook4 = session.get(CachingBook.class, 6); // In this case we have one select from DB(because we got one id from DB)

		//Get data with same id that one of them is after close session 
//		CachingBook cachingBook5 = session.get(CachingBook.class, 6);
//		tx.commit();
//		session.close();
//		session = sf.openSession();
//		session.beginTransaction();
//		CachingBook cachingBook6 = session.get(CachingBook.class, 6); 
//		session.getTransaction().commit();
//		session.close(); // This method does not appropriate & we need another level of caching
		
		
		//Second level Cache(Across Transaction)
		//Get data with same id that one of them is after close session 
//		CachingBook cachingBook7 = session.get(CachingBook.class, 6);
//		tx.commit();
//		session.close();
//		session = sf.openSession();
//		session.beginTransaction();
//		CachingBook cachingBook8 = session.get(CachingBook.class, 6); 
//		session.getTransaction().commit();
//		session.close();
		
		//Get data & update them & then get again with same id after close session 
		CachingBook cachingBook9 = session.get(CachingBook.class, 6);
		cachingBook9.setTitle("updated_title");
		tx.commit();
		session.close();
		Session newSession = sf.openSession();
		newSession.beginTransaction();
		CachingBook cachingBook10 = newSession.get(CachingBook.class, 6); 
		newSession.getTransaction().commit();
		newSession.close();
		
		
		
//		tx.commit();
//		session.close();
		
		
	}

}

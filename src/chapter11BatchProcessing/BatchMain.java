package chapter11BatchProcessing;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class BatchMain {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure("ProjectConfig.xml").buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		for(int i = 1; i < 10000; i++) {
			BatchBook batchBook = new BatchBook();
			batchBook.setTitle("book_title " + i);
			batchBook.setAuthor("book_author " + i);
			session.save(batchBook);/// Data is still in session
			if(i % 100 == 0) {
				session.flush();/// Data insert into DB
				session.clear();///Session is cleared
			}
		}
		
		tx.commit();
		session.close();

	}

}

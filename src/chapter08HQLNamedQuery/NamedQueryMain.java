package chapter08HQLNamedQuery;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class NamedQueryMain {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure("ProjectConfig.xml").buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
//		for(int i = 0; i<200; i++) {
//			NamedQueryBook namedQueryBook = new NamedQueryBook();
//			namedQueryBook.setTitle("book_title" + i);
//			namedQueryBook.setAuthor("book_author" + i);
//			session.save(namedQueryBook);
//		}		
		
		//A special column select
//		String hql = "select title from Book";
//		Query query = session.createQuery(hql);
//		List<String> bookTitles = query.list();
//		
//		for(String bookTitle: bookTitles) {
//			System.out.println(bookTitle.toString());
//		}
		
		//NamedQuery
//		Query query = session.getNamedQuery("allBooks");

		
		//Another NamedQuery
		Query query = session.getNamedQuery("bookById");
		query.setParameter("idValue", 26);
		
		List<NamedQueryBook> books = query.list();		
		tx.commit();
		session.close();
		
		for(NamedQueryBook book: books) {
			System.out.println(book.toString());
		}
		
		
	}

}

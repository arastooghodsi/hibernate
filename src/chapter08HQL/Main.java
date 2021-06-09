package chapter08HQL;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

	@SuppressWarnings({ "deprecation", "rawtypes" })
	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure("ProjectConfig.xml").buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		// Save data into DB
//		for(int i = 0; i<200; i++) {
//			Book book = new Book();
//			book.setTitle("book_title" + i);
//			book.setAuthor("book_author" + i);
//			session.save(book);
//		}
		
		// Select from DB with HQL query
//		Query query = session.createQuery("from Book");
//		List<Book> books = query.list();
		
		
		// Select with where from DB with HQL query
//		Query query = session.createQuery("from Book where title = 'book_title1'");
//		List<Book> books = query.list();
		
		//Select from DB with HQL query and by pagination
//		Query query = session.createQuery("from Book");
//		query.setFirstResult(70);
//		query.setMaxResults(60);
//		List<Book> books = query.list();
		
		
		//Select from DB with variable query(SQL injection problem)
//		String isValue = "100 or 1=1";
//		String hql = "from Book where id = " + isValue;
//		Query query = session.createQuery(hql);
//		List<Book> books = query.list();
		
		
		//Select from DB with Integer Parameter Binding
//		String hql = "from Book where id = ? or id = ?";
//		Query query = session.createQuery(hql);
//		query.setInteger(0, Integer.parseInt("100"));
//		query.setInteger(1, Integer.parseInt("50"));
//		List<Book> books = query.list();
		
		
		//Select from DB with Parameter Binding
//		String hql = "from Book where id=:idVlaue or title=:titleValue";
//		Query query = session.createQuery(hql);
//		query.setParameter("idVlaue", 100);
//		query.setParameter("titleValue", "book_title10");
//		List<Book> books = query.list();

		
		//Delete from DB with Parameter Binding
//		String hql = "delete from Book where id=:idValue";
//		Query query = session.createQuery(hql);
//		query.setParameter("idValue", 4);
//		query.executeUpdate();
		
		
		//Update DB with Parameter Binding
//		String hql = "update Book set title=:titleValue where id=:idValue";
//		Query query = session.createQuery(hql);
//		query.setParameter("idValue", 6);
//		query.setParameter("titleValue", "newTitle");
//		query.executeUpdate();
		
		
		tx.commit();
		session.close();
		
		// continue of select from DB with HQL query
//		for (Book book: books) {
//			System.out.println(book.toString());
//		}
		
	}

}

package chapter06;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class main {

	public static void main(String[] args) {

		Book book = new Book();
//		book.setTitle("C#");
//		book.setAuthor("Mahdi");
		
		SessionFactory sf = new Configuration().configure("ProjectConfig.xml").buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		//Insert data to DB with save() method
//		session.save(book);
		
		//Select data from DB with get() method
//		book = session.get(Book.class, 2);
		
		//Update data after get that from DB
//		book.setAuthor("Fatemeh");
		
		//Delete data from DB with get() and delete that
//		book = session.get(Book.class, 1);
//		session.delete(book);
		
		//Update DB by update() method
//		book = session.get(Book.class, 2);
//		book.setAuthor("Arastoo");
//		session.update(book);
		
		tx.commit();
		session.close();
		
		//Print selected data
		System.out.println(book.toString());
		
	}

}

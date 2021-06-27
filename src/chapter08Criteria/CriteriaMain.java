package chapter08Criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class CriteriaMain {

	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure("ProjectConfig.xml").buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		
		// Save data into DB
//		for(int i = 0; i<200; i++) {
//			CriteriaBook criteriaBook = new CriteriaBook();
//			criteriaBook.setTitle("book_title" + i);
//			criteriaBook.setAuthor("book_author" + i);
//			session.save(criteriaBook);
//		}
		
		
		//Simple Criteria
		Criteria criteria = session.createCriteria(CriteriaBook.class);
		
		//Criteria with conditions
		//where condition
//		criteria.add(Restrictions.eq("author", "arastoo"));
		
		//between condirion
//		criteria.add(Restrictions.between("id", 1, 10));
		
		
		//And several conditions(Default and operation for conditions)
//		Criterion whereCond = Restrictions.eq("author", "arastoo");
//		Criterion betweenCond = Restrictions.between("id", 1, 10);
		
		
		//Or conditions
//		Criterion whereCond1 = Restrictions.eq("author", "arastoo");
//		Criterion betweenCond1 = Restrictions.between("id", 1, 10);
//		Criterion orCond = Restrictions.or(whereCond1, betweenCond1);
//		criteria.add(orCond);
		
		
		//Order By
//		criteria.addOrder(Order.desc("id"));
		
		//LIKE
//		Criterion likeCond = Restrictions.like("title", "%title1%");
//		criteria.add(likeCond);
		
		//iLIKE : Like is case sensitive
//		Criterion iLikeCond = Restrictions.ilike("title", "%TITLE1%");
//		criteria.add(iLikeCond);
				
		List<CriteriaBook> criteriaBooks = criteria.list();
		
		
		tx.commit();
		session.close();
		
		for(CriteriaBook cb: criteriaBooks) {
			System.out.println(cb.toString());
		}

	}

}

package chapter08Criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
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
				
		
		//Projection
		//Count function
//		criteria.setProjection(Projections.count("id"));
//		List<Long> count = criteria.list();
		
		//Customize select
//		criteria.setProjection(Projections.property("title"));
//		List<String> titles = criteria.list();
		
		//Maximum value of a column
//		criteria.setProjection(Projections.max("id"));
//		List<Integer> max = criteria.list();
		
		//Blend of functions & criterions
//		criteria.setProjection(Projections.property("title"));
//		criteria.add(Restrictions.between("id", 195, 204));
//		List<String> titles = criteria.list();
		
		//Distinct
		criteria.setProjection(Projections.distinct(Projections.property("author")));
		criteria.add(Restrictions.between("id", 195, 204));
		List<String> authors = criteria.list();
		
//		List<CriteriaBook> criteriaBooks = criteria.list();
		
		
		tx.commit();
		session.close();
		
//		for(CriteriaBook cb: criteriaBooks) {
//			System.out.println(cb.toString());
//		}
		
//		for(Long criteriaBookLong: count) {
//			System.out.println(criteriaBookLong.toString());
//		}

//		for(String criteriaBookLong: titles) {
//			System.out.println(criteriaBookLong.toString());
//		}

		for(String criteriaBookLong: authors) {
			System.out.println(criteriaBookLong.toString());
		}

//		for(Integer criteriaBookLong: max) {
//			System.out.println(criteriaBookLong.toString());
//		}

		
	}

}

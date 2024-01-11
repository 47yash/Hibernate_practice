package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.demo.model.Product;

public class updttest {

	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Product p1=session.get(Product.class,1);
//		session.close();
		p1.setPname("mouse");
		session.saveOrUpdate(p1);
		tr.commit();
		
//		Session ss1=sf.openSession();
//		Product p2=ss1.get(Product.class,1);
//		System.out.println("before commit"+p2);
//		Transaction tr2=ss1.beginTransaction();
//		ss1.merge(p1);
//		tr2.commit();
//		ss1.close();
		session.close();
		sf.close();
		

	}

}

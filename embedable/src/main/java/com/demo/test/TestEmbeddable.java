package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.model.*;

public class TestEmbeddable {

	public static void main(String[] args) {
		Address add=new Address(1,"baker street","london");
		Address add1=new Address(1,"wall street","pata nahi");
		Myuser u1=new Myuser(10,"sherlock",add);
		Myuser u2=new Myuser(11,"john",add1);
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s1=sf.openSession();
		Transaction tr=s1.beginTransaction();
		s1.save(u1);
		s1.save(u2);
		
		tr.commit();
		

	}

}

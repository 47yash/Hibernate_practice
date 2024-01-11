package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.model.Myuser;



public class setrival {

	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session sess=sf.openSession();
		Transaction tr=sess.beginTransaction();
		//MyUser u1=sess.get(MyUser.class, 10);
		Myuser u1=sess.load(Myuser.class, 10);
		System.out.println("before");
		System.out.println(u1.getUname());
		System.out.println("after name");
		System.out.println(u1.getAdd());
		System.out.println("after");
	}

}

package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.model.Address;
import com.demo.model.Myuser;


public class UAtest {

	public static void main(String[] args) {
		Address addr=new Address(1,"baner","pune");
		Address addr1=new Address(2,"Deccan","pune");
		Myuser u1=new Myuser(10,"xxx",addr);
		Myuser u2=new Myuser(11,"yyy",addr1);
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session sess=sf.openSession();
		Transaction tr=sess.beginTransaction();
		sess.save(addr);
		sess.save(addr1);
		sess.save(u1);
		sess.save(u2);
		
		tr.commit();

	}

}

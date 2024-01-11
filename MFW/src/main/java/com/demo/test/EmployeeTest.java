package com.demo.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.demo.model.Employee;
import com.demo.model.MyUser;

public class EmployeeTest {

	public static void main(String[] args) {
		
//		Employee e1 =new Employee(19,"Rahul",254654);
//		Employee e2 =new Employee(10,"Rome",252324);
//		Employee e3 =new Employee(11,"Rajpal",251344);	
//		MyUser m1 =new MyUser(1,"YASH");
//		MyUser m2 =new MyUser(5,"vasu");
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s1 = sf.openSession();
		Transaction tr = s1.beginTransaction();
//		s1.save(e1);
//		s1.save(e2);
//		s1.save(e3);
//		s1.save(m1);
//		s1.save(m2);
				
//		Session s2=sf.openSession();
//		Transaction tr1=s2.beginTransaction();
//		Employee emp=s2.get(Employee.class,19 );
//		System.out.println("ber---");
//		System.out.println(emp.getEname());
//		System.out.println("after");
		Query q =s1.createQuery("from Employee");
		List<Employee> lst = q.list();
		System.out.println(lst);
		tr.commit();
		s1.close();
		}

}

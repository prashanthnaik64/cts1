package com.cts.HibernateInheritance;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
public class InherMain 
{
    public static void main( String[] args )
    {
    	SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Employee employee = new Employee("faname1","ln1",new Date(),"hr");
		session.save(employee);
		
		transaction.commit();
		session.close();
		System.out.println("done...");
        
    }
}


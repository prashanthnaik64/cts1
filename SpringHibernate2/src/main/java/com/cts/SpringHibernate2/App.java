package com.cts.SpringHibernate2;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Session session = new AnnotationConfiguration().configure("hibernate.cfg.xml")
				.buildSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
					
		  //Employee p1 = new Employee(); 
		  //p1.setPid(101);
		 /* p1.setEnane("Sush");
		  p1.setAge(22);
		  session.save(p1);		 
				
		  String hql = "from Employee";
			Query query = session.createQuery(hql);
			List list = query.list();
			for (int i = 0; i < list.size(); i++) {
				Employee s = (Employee)list.get(i);
				System.out.println(s.getEid()+","+s.getEnane());
			}
			
		  String hql = "select E.ename from Employee E";
			Query query = session.createQuery(hql);
			List list = query.list();
			for (int i = 0; i < list.size(); i++) {
				String name = (String)list.get(i);
				System.out.println("Name :"+name);
		
		  
		  String sql="from Employee E where E.age=22";
		  Query query=session.createQuery(sql);
		  List<Employee> list = query.list();
		 for (Object object : list) {
			 System.out.println((Employee)object);
			
		}	}*/
		  
		String hql = "from Employee S WHERE S.eid = :sudId";
		Query query = session.createQuery(hql);
		query.setParameter("sudId", 2);	
		List list = query.list();
		for (int i = 0; i < list.size(); i++) {
			Employee s = (Employee)list.get(i);
			System.out.println(s.getEid()+","+s.getEnane());
		}
		transaction.commit();
		
		session.close();
		System.out.println("annot done ...");
    }
        
    
}

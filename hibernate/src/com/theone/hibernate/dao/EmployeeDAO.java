package com.theone.hibernate.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.theone.hibernate.model.Employee;

public class EmployeeDAO {
	public static void main(String[] args) {
		//persistence objects
		
		Configuration cfg=new Configuration();
		cfg.configure();//it will helps us to get the configuration to connect DB(hibernate.cfg.xml)
		
		SessionFactory factory = cfg.buildSessionFactory();// it helps us to virtually connect the database
														// it also helps us to create multiple session object 
		Session session = factory.openSession();//helps us to create session object
		//session helps us to perform CURD operation
		
		Transaction transaction = session.beginTransaction();//it helps us to begin the transaction for commit and rollback operation
		
		
		//=============Create=============
//		Employee employee=new Employee();
//		employee.setId(101);
//		employee.setName("Azam");
//		session.save(employee);
		
		//==========Read==================
//		Employee employee = session.load(Employee.class, 101);
//		System.out.println(employee.getName()+" "+employee.getId());
		
		
		//=========update=================
//		Employee employee2 = session.load(Employee.class, 101);
//		employee2.setName("Amir");
//		session.update(employee2);
		
		//=========delete=================
//		Employee employee = session.load(Employee.class, 101);
//		session.remove(employee);
		
		//===========with the help of Query we can perform Read, Update and delete operation
		//===========Query without condition==
//		Query query = session.createQuery("from Employee");
//		List list = query.list();
//		list.forEach(System.out::println);
		
		//===========Query wit condition==
//		Query query = session.createQuery("from Employee where id=101");
//		Employee employee = (Employee) query.uniqueResult();
//		System.out.println(employee);
		
		//==========Criteria=============Note: only for Read operation
		/*
		 * Criteria criteria=session.createCriteria(Employee.class);//select* frome emp
		 * criteria.add(Restrictions.eq("id", 101));//where condition
		 * 
		 * Employee employee = (Employee) criteria.uniqueResult();
		 * System.out.println(employee);
		 */
		//=========Criteria without any condition===========
		Criteria criteria=session.createCriteria(Employee.class);//selet* from emp
		List list = criteria.list();
		list.forEach(System.out::println);
		
		transaction.commit();//now data will be commit to the database.
		session.close();
		factory.close();
		
	}
}

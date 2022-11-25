package com.hibernate.many2many_mapping;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;	
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Mapping {
	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory =cfg.buildSessionFactory();
		
		Employee e1=new Employee();
		Employee e2=new Employee();
		
		e1.setEid(101);
		e1.setName("Ram");
		
		
		e2.setEid(102);
		e2.setName("Shyam");
		
		Project p1=new Project();
		Project p2=new Project();
		
		p1.setPid(101);
		p1.setProjectName("FullStack Project");
		
		p2.setPid(102);
		p2.setProjectName("Front-end Project");
		
		
		List<Employee>list1=new ArrayList<Employee>();
		list1.add(e1);
		list1.add(e2);
		
		
		
		List<Project>list2=new ArrayList<Project>();	
		list2.add(p1);
		list2.add(p2);
		
		
		e1.setProjects(list2);
		e2.setProjects(list2);
		p1.setEmployees(list1);
		p2.setEmployees(list1);
		
		Session session=factory.openSession();
		Transaction trx=session.beginTransaction();
		
		session.save(e1);
		session.save(e2);
		session.save(p1);
		session.save(p2);
		
		trx.commit();
		session.close();
		factory.close();
	}

}

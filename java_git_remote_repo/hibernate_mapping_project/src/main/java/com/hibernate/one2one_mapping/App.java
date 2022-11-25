package com.hibernate.one2one_mapping;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App 
{
    public static void main( String[] args )throws IOException
    {
        System.out.println( "Hello World!" );

        
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();
        
        //creating object of Student
        Student st=new Student();
        st.setId(101);
        st.setName("Indra Gandhi");
        st.setCity("New Delhi");
        System.out.println(st);
        
        
        Certificate cert=new Certificate();
		cert.setCourse("Hibernate");
		cert.setDuration("4 Days");
		st.setCertificate(cert);
        
        
        //creating object of Address
        Address add=new Address();
        add.setStreet("Road no1");
        add.setCity("Coimbatore");
        add.setOpen(true);
        add.setAddedDate(new Date());
        add.setX(1222.3333);
        //Reading Image
        
        FileInputStream fis= new FileInputStream("src/main/java/IBM.pdf");
        byte[] data=new byte[fis.available()];
        fis.read(data);
        add.setImage(data);
        
        
       

       Session session= factory.openSession();
       Transaction trx=session.beginTransaction();
       
       session.persist(st);
       session.persist(add);
        
       trx.commit();        
       
       
       session.close();
  

        System.out.println("Done");
    }
}

package com.demo1.HibernateExampleDemo;

import javax.sound.midi.Soundbank;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 Hibernate Demo 1:
 Create a "hibernate.cfg.xml" file and specify all the db details, username, password etc
 Connect that file to database
 */
public class App 
{
    public static void main( String[] args )
    {
    	// Creating an Object of "StudentFullAddress" class and setting values to the variables.
    	StudentFullAddress AddressObj=new StudentFullAddress();
    	AddressObj.setCity("Noida");
    	AddressObj.setState("UP");
    	AddressObj.setCountry("India");
    	
    	
    	
    	// Creating an Object of "Student" class and setting values to the variables.
    	Student stud1=new Student();
    	stud1.setStudID(107);
    	stud1.setStudName("Raman");
    	stud1.setPhoneNumber("9244544434");
    	stud1.setStudentFullAddress(AddressObj);  // Passing AddressObj as reference, so that it can fetch values from that Object.
    	
        System.out.println( " Started !" );
        
        Configuration con=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class);
        SessionFactory sf=con.buildSessionFactory();
        Session session=sf.openSession();
        
       // Storing (or) Saving the data in Database
       Transaction tx=session.beginTransaction();
       session.persist(stud1);  // persist() method used to save data
       tx.commit();  // commit the transaction
       System.out.println("Data saved successfully !");
       
       
       //Retrieving (or) reading (or) getting data from Database
       
//      Session readSession=sf.openSession();
//      Transaction readTransaction= readSession.beginTransaction();
//      stud1= readSession.get(Student.class,105);  //Specify the ClassName and PrimaryKey value
//      readTransaction.commit();
//      System.out.println("Retrieved Data : "+stud1);
//      readSession.close();
      
       
       
        
    }
}

package com.MappingRelation.ManyToManyLibraryManagement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/*
 Library Management System

 => Now Built a simple Library Management System. In this system:
 => A Book can be borrowed by many Students.
 => A Student can borrow many Books.
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Starting Application !" );
        
       Book book1= new Book(401,"Can we be Strangers Again!",230,2);
       Book book2=new Book(402,"Business Book",450,1);
       Book book3=new Book(403,"Cooking Book",300,4);
       Book book4=new Book(404,"Photography Books",500,5);
       
       
       Student student1=new Student(301,"Ramu","CSE","Warangal");
       Student student2=new Student(302,"Kalyan","ECE","Kakinada");
       Student student3=new Student(303,"Shiva","EEE","Karimnagar");
       Student student4=new Student(304,"Ramesh","Civil","Tirupathi");

       student2.addBooks(book1);
       student2.addBooks(book4);
//       student2.addBooks(book2);
       
       book1.addStudents(student2);
       book4.addStudents(student2);
//       book1.addStudents(student4);
       
       Configuration con= new Configuration().configure().addAnnotatedClass(Book.class).addAnnotatedClass(Student.class);
       SessionFactory sf= con.buildSessionFactory();
       Session saveSession=sf.openSession();
       Transaction saveTransaction= saveSession.beginTransaction();
       saveSession.persist(student1);
       saveSession.persist(student2);
       saveSession.persist(student3);
       saveSession.persist(student4);
       saveSession.persist(book1);
       saveSession.persist(book2);
       saveSession.persist(book3);
       saveSession.persist(book4);
       System.out.println("Data saved successfully !");
       saveTransaction.commit();
       System.out.println(" Transaction commited successfully !");
       saveSession.close();
       
       //Retrieving data by studentID
       Session readSession=sf.openSession();
       Student studentObject= readSession.get(Student.class, student1.getStudentID());
       System.out.println("Retrieved data from Database : "+studentObject);
       studentObject.getBookClassReference().forEach(System.out::println);
       readSession.close();
       
       sf.close();
    }
}





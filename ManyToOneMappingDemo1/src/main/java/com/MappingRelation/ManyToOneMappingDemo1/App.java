package com.MappingRelation.ManyToOneMappingDemo1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
You’re building an e-commerce application. Each Order belongs to exactly one Customer, but each Customer can have multiple Orders.

Task:

=> One Customer Multiple Orders

Create two Hibernate entities: Customer and Order.

Use @ManyToOne in the Order entity to map the relationship.

Save a few Customers and their Orders into the database.

Retrieve all Orders for a specific Customer.
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Application Started!" );
        
        Orders order1=new Orders("Tshirt","Secundrabad",200);
        Orders order2=new Orders("Hoodie","Karimnagar",599);
//        Orders order3= new Orders("iPhone","Kakinada");
//        Orders order4=new Orders("Pulsar 150","Hyderabad");
        
        
        Customer customer1=new Customer(105, "Ramesh","9349398423","ramesh84@gmail.com");
        customer1.addOrderedItem(order1);
        customer1.addOrderedItem(order2);
//        customer1.addOrderedItem(order3);
//        customer1.addOrderedItem(order4);
        
        Configuration con=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class).addAnnotatedClass(Orders.class);
        
        SessionFactory sf=con.buildSessionFactory();
        
        
        // Saving (or) Persisting Data into Database
        Session saveSession=sf.openSession();
        Transaction savetransaction= saveSession.beginTransaction();
//        saveSession.persist(customer1);
//        savetransaction.commit();
        System.out.println("Customer Added Items to cart !");
        saveSession.close();
        
        
        
        // Reading (or) Retrieving data from Database
        Session readSession = sf.openSession();
        Transaction readTransaction= readSession.beginTransaction();
        Customer retrievedcustomer=  readSession.get(Customer.class, 105);
        System.out.println("Customer Name is : "+ retrievedcustomer.getCustomerName() + " . Customer ID is : "+ retrievedcustomer.getCustID() +
        		" . Customer Contact Number is :"+retrievedcustomer.getCustomerContactNumber() + " .Customer Email is : "+retrievedcustomer.getCustomerEmail());
//        System.out.println("Ordered Items are : "+customer1.getOrderClassReference());
        retrievedcustomer.getOrderClassReference().forEach(item -> System.out.println(item));
        readTransaction.commit();
        readSession.close();
        sf.close();
        
    }
}

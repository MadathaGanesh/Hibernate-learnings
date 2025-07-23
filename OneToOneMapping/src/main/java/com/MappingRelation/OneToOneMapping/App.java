package com.MappingRelation.OneToOneMapping;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


/*
 How would you design a database to store a user’s profile and their unique passport information?
 - Create User Table and Passport Table
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Implementing One to One Relationship !" );
        
       // Step 1: Create UserProfile Object and assign values to them using setters
       UserProfile userprofileObject=new UserProfile();
       userprofileObject.setUserID(104);
       userprofileObject.setUserName("harish");
       userprofileObject.setAddress("karemabad");
       
       // Step 2: Create Object for PassportObject and assign values to them using setters
       Passport passportObject =new Passport();
       passportObject.setPassport_Number("yei230");
       passportObject.setCountry("USA");
       passportObject.setIssueDate(LocalDate.of(2021, 10, 23));
       
       //Step 3: Establish the relationship b/w them in both ways
       userprofileObject.setPasspotObject(passportObject); // Owning side
       passportObject.setUserprofile(userprofileObject); // Inverse side
       
       
       // Step 4: configure Hibernate 
       Configuration con=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Passport.class).addAnnotatedClass(UserProfile.class);
       SessionFactory sf= con.buildSessionFactory();
       Session session=sf.openSession();
       
       Transaction transaction=session.beginTransaction();
       
       
       // Step 5: Persist/save the owning side or both (both is fine if cascade =ALL)
       session.persist(passportObject);
       session.persist(userprofileObject);
    
       transaction.commit();
       System.out.println("Transaction commited successfully ! ");
       
      System.out.println("Userprofile details are : "+ userprofileObject.toString());
      System.out.println("Passport details are : "+passportObject.toString());
       session.close();
       
       
       
       
       // Retrieving the data
       Session readsession=sf.openSession();
       Transaction readtransaction=readsession.beginTransaction();
       passportObject= readsession.get(Passport.class, 6);
       readtransaction.commit();
       System.out.println("Retrieved data is : "+passportObject);
       
       
    }
}




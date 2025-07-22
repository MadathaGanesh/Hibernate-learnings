package com.MappingRelation.OneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


/* 
 Let’s say you have a Department and Employee:

One Department can have many Employees

An Employee belongs to one Department
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Application started!" );
        
        Configuration con=new Configuration().configure().addAnnotatedClass(Employee.class).addAnnotatedClass(Department.class);
        SessionFactory sf=con.buildSessionFactory();
        
        Session savesession=sf.openSession();
        
        try {
            Transaction saveTransaction=savesession.beginTransaction();
            
            //Creating Department object
            Department dept=new Department("IT Department");
            
            //Creating Employees
            Employee emp1=new Employee("GAnesh", "Warangal");
            Employee emp2=new Employee("Ramesh","Ramanagar");
            Employee emp3=new Employee("Sunny","Sand nagar");  
            
            // Associate employees with department
            dept.addEmployee(emp1);
            dept.addEmployee(emp2);
            dept.addEmployee(emp3);
            
            //Save the dept data
//            savesession.persist(dept);
            saveTransaction.commit();
            System.out.println("Department and employees saved successfully! ");
            
            // Retrieving data by deptID
            Session readsession=sf.openSession();
            Transaction readtransaction=readsession.beginTransaction();
            Department retrievedData=readsession.get(Department.class, dept.getDeptID());
            System.out.println("LOading Department : "+retrievedData.getDeptName());
            retrievedData.getEmployees().forEach(emp-> System.out.println(emp));
            
            readsession.getTransaction().commit();
            
       
            readsession.close();
            
			
		} catch (Exception e) {
			System.out.println("Error occured ! "+e);
		}
        
        
    }
}

package com.sp.main.JPQLprogramselect;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.sp.entity.Employee;

import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EntityManagerFactory entitymanagerfact=Persistence.createEntityManagerFactory("main-persistence");
         EntityManager em= entitymanagerfact.createEntityManager();
         
        //select employee id form the 
         try {
         String jql_query="Select e from Employee e";
       TypedQuery<Employee> query= em.createQuery(jql_query,Employee.class);
        
         List<Employee> list_emp= query.getResultList();
         
         
         for(Employee emp:list_emp)
         {
        	 System.out.println("ID  "+ emp.getEmployee_id());
        	 System.out.println("Firstname  "+ emp.getEmployee_firstname());
        	 System.out.println("Last Name  "+ emp.getLast_firstname());
        	 System.out.println("Address "+ emp.getAdress());
        	 System.out.println("Pincode "+ emp.getPincode());
        	 System.out.println("------------------------------------------");
         }
        
         
        		 
         }
         catch(Exception e)
         {
        	 e.printStackTrace();
         }
         finally {
        	 em.close();
         }
    }
}

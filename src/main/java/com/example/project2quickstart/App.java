package com.example.project2quickstart;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import model.employee;

public class App 
{
    public static void main( String[] args )
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myjpa-unit");
        EntityManager em = emf.createEntityManager();
        
        employee e2 = new employee();
        
        e2.setEmail("pavan113@gmail.com");
        e2.setPassword("1a12323g");
        EntityTransaction et=em.getTransaction();
        try {
        	et.begin();
        	em.persist(e2);
            et.commit();
            System.out.println("sucessfully inserted");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
        finally {
        	emf.close();
        	em.close();
        }
    }
}

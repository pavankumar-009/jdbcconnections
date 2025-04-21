package com.example.project2quickstart;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import model.employee;

public class insertion {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myjpa-unit");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et =em.getTransaction();
        try {
        	//for fetching data dynamically
//        	List<employee> li = em.createQuery("from employee",employee.class).getResultList();
//        	for (employee e : li) {
//        		System.out.println("ld: "+ e.getId());
//        		System.out.println("Email: "+ e.getEmail());
//        		System.out.println("password: "+ e.getPassword());
        	int id = 102;
        	et.begin();;
        	employee e = em.find(employee.class,id);
        	if(e !=null) {
        		//System.out.println(e.getEmail());
        		//for deletion
        		em.remove(e);
        		System.out.println("sucessfuly deleted");
        		et.commit();
        		//for updating data
//        		e.setEmail("pavan@gmail.com");
//        		e.setPassword("asdewq");
//        		em.merge(e);
//        		et.commit();
//        		System.out.println("data updated sucessfully");
        	}
        	else {
        		System.out.println("user not find");
        	}
        		
			
		 }catch (Exception e1) {
			e1.printStackTrace();
		}
        finally {
        	emf.close();
        	em.close();
        }
	}

}

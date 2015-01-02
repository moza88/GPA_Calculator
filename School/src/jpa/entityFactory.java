package jpa;
import java.util.Iterator;
import java.util.List;

import javax.persistence.*;



public class entityFactory {
	/*Creating Entity Factory Manager
		Responsible for creating EntityManager instances.
		Initialized with the help of persistence context.
	*/
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("School");
	
	/*Creating Entity Manager
	 	Performs the real work of persistence.
		Performs create, update and delete operations on entities in persistence context.
		Brings entities into persistence context and then entity is supposed to be managed by EntityManager .
		Multiple EntityManager instances can be created from EntityManagerFactory .
	 */
	
	EntityManager em = emf.createEntityManager();
	/*
		if (null != em) {
			EntityTransaction readTransaction = em.getTransaction();
			readTransaction.begin();
			Query query = em.createNamedQuery("select * from student");
			List list = query.getResultList();
			Iterator iterator = student.iterator()) {
			while (iterator.hasNext()) {
				Object firstName = iterator.next(); 
				System.out.print(firstName + " "); 
			}
			*/
			}
		
	


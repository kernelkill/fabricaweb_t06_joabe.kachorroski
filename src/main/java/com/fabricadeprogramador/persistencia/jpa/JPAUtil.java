package com.fabricadeprogramador.persistencia.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
private static final String PERSISTENCE_UNITY = "cjweb";
	
	
	private static EntityManagerFactory entityManagerFactory;
	
	public static EntityManager getEntityManager(){
		
		if(entityManagerFactory == null){
			entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNITY);
		}
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		
		return entityManager;
	}

}

package controllers;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import models.Etudiant;
import models.Groupe;
import models.Professeur;

public class DbConnection {

	private Session session;
	private SessionFactory factory;
	
	private static DbConnection instance = new DbConnection();
	
	public static DbConnection getInstance() {
        return instance;
    }
	
	public DbConnection() {
		
	}
	
	public boolean open() {
		
		factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Etudiant.class)
				.addAnnotatedClass(Groupe.class)
				.addAnnotatedClass(Professeur.class)
				.buildSessionFactory();
		session = factory.getCurrentSession();

		try {
			
		  session.beginTransaction();
			return true;
			
		} catch (Exception e) {
			System.out.println("impossible d'ouvrir la séssion: " + e.getMessage());
			return false;
		}
	}

	public void close() {
		try {
			if (session != null) {
	             session.close();
	             factory.close();
	         }
		}
       catch (Exception e) {
        System.out.println("Impossible de fermer la session: " + e.getMessage());
    }
		 
}

	public void refreshEntityManager() {
		//session.EntityManagerFactory.createEntityManager();
	}
	public Session getSession() {
		return session;
	}

	public SessionFactory getFactory() {
		return factory;
	} 
	
}


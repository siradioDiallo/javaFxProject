package application;
	
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javafx.application.Application;
import javafx.stage.Stage;
import models.Etudiant;
import models.Groupe;


public class CreatGroupe extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Etudiant.class)
				.addAnnotatedClass(Groupe.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			//start transaction
			session.beginTransaction();
			
			
			//création groupe
			Groupe grp0 = new Groupe("pr300");
			Groupe grp1 = new Groupe("pr302");
			Groupe grp2 = new Groupe("res300");
			Groupe grp3 = new Groupe("res310");
			Groupe grp4 = new Groupe("res410");
			
			//saving groupes 
			session.save(grp4);
			session.save(grp0);
			session.save(grp1);
			session.save(grp2);
			session.save(grp3);
			
			/*
			List<Groupe> groupes= session.createQuery("from Groupe").getResultList();
			
				for(Groupe grp:groupes) {
					System.out.println("nom:"+grp.getNomGroupe());
					session.delete(grp);
				}
				
			*/
			/*
			//récupération et affichage d'un groupe
			System.out.println("Getting Groupe id=1");
			int grpId=4;
			
			Groupe grp = session.get(Groupe.class, grpId);
			System.out.println("id:"+grp.getGroupeId()+" nom:"+grp.getNomGroupe());
			
			//Affichage des Etudiants du groupe 2
			System.out.println("Affichage des Etudiants du groupe 2:");
			if(grp.getEtudiants()==null) {
				System.out.println("groupe vide");
			}
			for(Etudiant et:grp.getEtudiants()) {
				System.out.println(et.toString());
			}
			*/
			//save groupe
			//session.save(grp);
			

			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done !");
			//
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		finally {
			factory.close();
			session.close();
			System.exit(0);
			
		}
		
	}
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
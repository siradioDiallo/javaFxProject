package application;
	
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import javafx.application.Application;
import javafx.stage.Stage;
import models.Etudiant;
import models.Groupe;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class CreatEtudiant extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Etudiant.class)
				.addAnnotatedClass(Groupe.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			
			//création d'un étudiant
			System.out.println("Création de l'étudiant");
			
			Etudiant e1 = new Etudiant("SDK026555", "F","Sow","Amadou","Castor","14/12/24400","Sénégal",
					"Sénégalaise","célibataire","774569845","das@gmail.com","B+");
			Etudiant e2 = new Etudiant("SDK0260055", "F","Sall","Abdou","Castor","14/12/2040","Sénégal",
					"Sénégalaise","célibataire","774569845","das@gmail.com","B+");
			Etudiant e3 = new Etudiant("SDK026666", "F","Diop","Rama","Castor","14/12/200110","Sénégal",
					"Sénégalaise","célibataire","774569845","das@gmail.com","B+");
			Etudiant e4 = new Etudiant("SDK8955", "F","Diallo","Ibrahima","Castor","14/12/258800","Sénégal",
					"Sénégalaise","célibataire","774569845","das@gmail.com","B+");
			
			//start transaction
			session.beginTransaction();
			
			//save student 
		    session.save(e1);
		    session.save(e4);
		    session.save(e3);
		    session.save(e2);
		    
		    //commmit transcations
		    session.getTransaction().commit();
		    	
			//recupération de tous les étudiants
		    
		    
			//recupération des étudiant existant
		     List<Etudiant> ets = session.createQuery("from Etudiant").getResultList();
			 
			
			
			if(ets==null) {
				System.out.println("vide");
			}
			for(Etudiant et:ets) {
				System.out.println("Id:"+et.getNom()+" nom:"+et.getMatricule());
			}
			
			System.out.println("Récupération d'un étudiant ...");
			 //int idstd1 =2;
			//Etudiant eGetted= session.get(Etudiant.class, idstd1);
			
			//récupération d'un groupe
			System.out.println("Getting Groupe par Id");
			 //int grpId=1;
			 //Groupe grp = session.get(Groupe.class, grpId);
			
			//System.out.println("sauvegarde en cours ...");
			//save etudiant
			//session.save(e1);
			
			//commit transaction
			//session.getTransaction().commit();
			System.out.println("Done !");
			//
			
			System.out.println("sauvegarde en cours ...");
			//save etudiant
	
		}
		catch(Exception ex) {
			ex.printStackTrace();
			
		}
		
		finally {
			session.close();
			factory.close();
			System.exit(0);		}
		
	
	}
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}

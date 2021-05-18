package controllers;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import models.Etudiant;
import models.Groupe;

public class MainController {
	
List<Etudiant> etudiants;
List<Groupe> groupes;

public MainController() {
	
	SessionFactory factory = DbConnection.getInstance().getFactory();
	Session session = DbConnection.getInstance().getSession();
	try {
		//Gestion etudiant 
	     /*
		 GestionEtudiantController ges = new GestionEtudiantController();
		 
		 System.out.println("------------------");
		 System.out.println("Affichages des étudiants ");
		 ges.showAll();
		 System.out.println("------------------");
		 System.out.println("Updating de l'étudiant d'id 1");
		Etudiant e1=ges.getById(1);
		 ges.update(1);
		 System.out.println("updating terminer");
		 
		 System.out.println("------------------");
		 System.out.println("Affichage de l'étudiant après update ");
		 ges.showDetail(1);
		 */
		
		//Gestion Groupe
		/*
		GestionGroupeController gesGrp = new GestionGroupeController();
		System.out.println("-----------------------------");
		System.out.println("Affichages des groupes ");
		gesGrp.showAll();
		System.out.println("-----------------------------");
		System.out.println("Ajout d'un groupe ");
		Groupe gp = new Groupe("pr214");
		gesGrp.add(gp);
		System.out.println("-----------------------------");
		System.out.println("Affichages des groupes  après ajout");
		gesGrp.showAll();
		System.out.println("-----------------------------");
		System.out.println("Moddification d'un groupe ");
		gesGrp.update(2);
		System.out.println("Affichage du groupe apres update ");
		gesGrp.showDetail(2);
		*/
		
		//Gestion Groupe Etudiant 
		int id=1;
		Groupe gp = session.get(Groupe.class, id);
		GestionGroupeEtudiantController gge = new GestionGroupeEtudiantController(gp);
		System.out.println("-----------------------------");
		System.out.println("Ajout d'étudiant au groupe");
		int ide1 =1;
		int ide2 =4;
		Etudiant e1 =gge.getEtudiantById(6);
		Etudiant e2 =gge.getEtudiantById(7);
		Etudiant e3 =gge.getEtudiantById(8);
		//Etudiant e2 = gge.getEtudiantById(ide2);
		gge.add(e1);
		session = factory.getCurrentSession();
		session.beginTransaction();
		System.out.println("sos");
		gge.add(e2);
		session = factory.getCurrentSession();
		session.beginTransaction();
		System.out.println("sos");
		gge.add(e3);
		System.out.println("-----------------------------");
		System.out.println("Affichages des étudiant du groupe");
		gge.showAll();
		
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	
	
	}
   
    


}


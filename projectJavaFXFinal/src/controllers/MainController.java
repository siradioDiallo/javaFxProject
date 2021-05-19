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
		gge.add(e2);
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


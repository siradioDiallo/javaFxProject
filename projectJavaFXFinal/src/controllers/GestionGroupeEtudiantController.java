package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;
import interfaces.IGestionGE;
import models.Etudiant;
import models.Groupe;

public class GestionGroupeEtudiantController implements IGestionGE {

	Session session;
	List<Groupe> allGroupes;
	List<Etudiant> allEtudiants;
	Groupe gp;
	
	public GestionGroupeEtudiantController(){
		
	}
	
	public GestionGroupeEtudiantController(Groupe gp) {
		session=DbConnection.getInstance().getSession();
		allGroupes =session.createQuery("from Groupe").getResultList();
		allEtudiants = session.createQuery("from Etudiant").getResultList();
		this.gp=gp;
		 
	}
	
	@Override
	public void add(Etudiant e) {
		// TODO Auto-generated method stub
		List<Etudiant>listEtudiant =gp.getEtudiants();
		try {
			if(listEtudiant==null) {
				gp.setEtudiants(new ArrayList<Etudiant>());
			}
			else  
			{
				if(getEtudiantById(e.getEtudiantId())!=null)
				{
				   listEtudiant.add(e);
				   gp.setEtudiants(listEtudiant);
					e.setGroupe(gp);
					session.getTransaction().commit();
				}
				else
				{
					System.out.println("Etudiant indisponible ");
				}
			}
			
			
		}
		catch(NullPointerException ex) {
			System.out.println("étudiant idinsponible :"+ex.getMessage());
		}
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		if(getEtudiantById(id)!=null) {
			Etudiant e = getEtudiantById(id);
			e.setGroupe(null);
			session.getTransaction().commit();
		}
	}

	@Override
	public void showAll() {
		// TODO Auto-generated method stub
		List<Etudiant> listEtudiant=gp.getEtudiants();
		try {
			if(listEtudiant==null) {
		    	System.out.println("ce groupe est vide !");
		    }
		    else 
		    {
		    	for(Etudiant etud:listEtudiant) {
		    		System.out.println(etud.toString());
		    	}
		   	}
		}
		catch(NullPointerException ex) {
			System.out.println("groupe vide:"+ex.getMessage());
		}
		
	}

	@Override
	public Etudiant getEtudiantById(int id) {
		// TODO Auto-generated method stub
		try {
			Etudiant e = session.get(Etudiant.class, id);
			if(e!=null) {
				return e;
			}
			else {
				return null;
			}
		}
		catch(NullPointerException ex) {
			System.out.println("étudiant idinsponible :"+ex.getMessage());
			return null;
		}
	}

	public Groupe getGp() {
		return gp;
	}

	public void setGp(Groupe gp) {
		this.gp = gp;
	}

	
}

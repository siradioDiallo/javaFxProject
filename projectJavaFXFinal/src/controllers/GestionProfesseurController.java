package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import interfaces.IModification;
import models.Etudiant;
import models.Professeur;

public class GestionProfesseurController implements IModification<Professeur>{
	
	List<Professeur> professeurs;
	Session session;
	SessionFactory factory;

	
	public GestionProfesseurController() {
	
		try {
			session=DbConnection.getInstance().getSession();
			factory=DbConnection.getInstance().getFactory();
			professeurs = session.createQuery("from Professeur").getResultList();
		}
		catch(Exception e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void add(Professeur professeur) {
		if(professeurs==null) {
			professeurs = new ArrayList<>();
		}
		else {
			session.save(professeur);
			session.getTransaction().commit();
			professeurs.add(professeur);
		}
	}

	@Override
	public void delete(Professeur toDel) throws NullPointerException{
		// TODO Auto-generated method stub
		Professeur e = getById(toDel.getId())	;

		if(e!=null) {
			session.delete(toDel);
			professeurs.remove(toDel);
			session.getTransaction().commit();
		}
	}

	@Override
	public void update(Professeur prof) throws NullPointerException{
		// TODO Auto-generated method stub
		   Professeur profe = getById(prof.getId());
		   
		if(profe!=null) {
		 session.update(profe);
			session.getTransaction().commit();
		}

	}

	@Override
	public void showDetail(int id) {
		// TODO Auto-generated method stub
		if(getById(id)!=null) {
			Professeur etud = getById(id);
			System.out.println(etud.toString());
		}
	}

	@Override
	public void showAll() {
		// TODO Auto-generated method stub
		if(professeurs.isEmpty()) {
	    	System.out.println("Aucune donnée n'a été enregistré");
	    }
	    else 
	    {
	    	for(Professeur ets:professeurs) {
	    		System.out.println("Nom:"+ets.getNom()+" Prénom:"+ets.getPrenom()+" Matricule:"+ets.getMatricule());
	    	}
	   	}
	}

	@Override
	public List<Professeur> findAll() {
		// TODO Auto-generated method stub
		return professeurs;
	}

	@Override
	public Professeur getById(int id) {
		// TODO Auto-generated method stub
		try {
			Professeur e = session.get(Professeur.class, id);
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
		
}

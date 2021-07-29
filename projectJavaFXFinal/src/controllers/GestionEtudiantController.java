package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import interfaces.IModification;
import models.Etudiant;

public class GestionEtudiantController implements IModification<Etudiant>{
	
	List<Etudiant> etudiants;
	Session session;
	SessionFactory factory;
	Scanner sc;
	
	public GestionEtudiantController() {
	
		try {
			session=DbConnection.getInstance().getSession();
			factory=DbConnection.getInstance().getFactory();
			etudiants = session.createQuery("from Etudiant").getResultList();
			sc = new Scanner(System.in);
		}
		catch(Exception e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void add(Etudiant etudiant) {
		if(etudiants==null) {
			etudiants = new ArrayList<>();
		}
		else {
			session.save(etudiant);
			session.getTransaction().commit();
			etudiants.add(etudiant);
		}
	}

	@Override
	public void delete(Etudiant toDel) throws NullPointerException{
		// TODO Auto-generated method stub
		Etudiant e = getById(toDel.getEtudiantId())	;

		if(e!=null) {
			session.delete(toDel);
			etudiants.remove(toDel);
			session.getTransaction().commit();
		}
	}

	@Override
	public void update(Etudiant e) throws NullPointerException{
		// TODO Auto-generated method stub
		Etudiant etud = getById(e.getEtudiantId())	;
		if(etud!=null) {
			session.update(etud);
			session.getTransaction().commit();
		}

	}

	@Override
	public void showDetail(int id) {
		// TODO Auto-generated method stub
		if(getById(id)!=null) {
			Etudiant etud = getById(id);
			System.out.println(etud.toString());
		}
	}

	@Override
	public void showAll() {
		// TODO Auto-generated method stub
		if(etudiants.isEmpty()) {
	    	System.out.println("Aucune donnée n'a été enregistré");
	    }
	    else 
	    {
	    	for(Etudiant ets:etudiants) {
	    		System.out.println("Nom:"+ets.getNom()+" Prénom:"+ets.getPrenom()+" Matricule:"+ets.getMatricule());
	    	}
	   	}
	}

	@Override
	public List<Etudiant> findAll() {
		// TODO Auto-generated method stub
		return etudiants;
	}

	@Override
	public Etudiant getById(int id) {
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
			System.out.println("érreur :"+ex.getMessage());
			return null;
		}
		
	}
		
}

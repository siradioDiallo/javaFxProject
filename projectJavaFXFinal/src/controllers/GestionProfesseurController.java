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
	Scanner sc;
	
	public GestionProfesseurController() {
	
		try {
			session=DbConnection.getInstance().getSession();
			factory=DbConnection.getInstance().getFactory();
			professeurs = session.createQuery("from Professeur").getResultList();
			sc = new Scanner(System.in);
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
	public void update(int id) throws NullPointerException{
		// TODO Auto-generated method stub
		
		if(getById(id)!=null) {
			Professeur etud = getById(id);

			System.out.println("");
			System.out.println("Entrer le nom de l'�tudiant:");
			etud.setNom(sc.nextLine());
			//sc.nextLine();
			System.out.println("Entrer le Pr�nom de L'�tudiant:");
			etud.setPrenom(sc.nextLine());
			System.out.println("Entrer le matricule de L'�tudiant:");
			etud.setMatricule(sc.nextLine());
			System.out.println("Entrer le genre de L'�tudiant:");
			etud.setGenre(sc.nextLine());
			System.out.println("Entrer l'adresse de L'�tudiant:");
			etud.setAdresse(sc.nextLine());
			System.out.println("Entrer la date de L'�tudiant:");
			etud.setDateNaissance(sc.nextLine());
			System.out.println("Entrer le lieu de naissance de L'�tudiant:");
			etud.setLieuNaissance(sc.nextLine());
			System.out.println("Entrer la nationalit� de L'�tudiant:");
			etud.setNationalite(sc.nextLine());
			System.out.println("Entrer la situation matrimoniale de L'�tudiant:");
			etud.setSituationMatrimoniale(sc.nextLine());
			System.out.println("Entrer le num�ro de L'�tudiant:");
			etud.setTel(sc.nextLine());
			System.out.println("Entrer l'email de L'�tudiant:");
			etud.setEmail(sc.nextLine());
			System.out.println("Entrer le groupe sanguin de L'�tudiant:");
			etud.setSpeciality(sc.nextLine());
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
	    	System.out.println("Aucune donn�e n'a �t� enregistr�");
	    }
	    else 
	    {
	    	for(Professeur ets:professeurs) {
	    		System.out.println("Nom:"+ets.getNom()+" Pr�nom:"+ets.getPrenom()+" Matricule:"+ets.getMatricule());
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
			System.out.println("�tudiant idinsponible :"+ex.getMessage());
			return null;
		}
		
	}
		
}

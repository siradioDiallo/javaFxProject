package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import interfaces.IModification;
import models.Groupe;


public class GestionGroupeController implements IModification<Groupe> {
	List<Groupe> groupes;
	Session session;
	
	public GestionGroupeController() {
		try {
			session=DbConnection.getInstance().getSession();
			groupes = session.createQuery("from Groupe").getResultList();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void add(Groupe toAdd) {
		// TODO Auto-generated method stub
		if(groupes==null) {
			groupes = new ArrayList<>();
		}
		else {
			session.save(toAdd);
			session.getTransaction().commit();
			groupes.add(toAdd);
		}
	}

	@Override
	public void delete(Groupe toDel) {
		// TODO Auto-generated method stub
		Groupe gp = getById(toDel.getGroupeId());

		if(gp!=null) {
			session.delete(toDel);
			groupes.remove(toDel);
			session.getTransaction().commit();
		}
	}

	@Override
	public void update(Groupe toMaj) {
		// TODO Auto-generated method stub
		
		Groupe gp = getById(toMaj.getGroupeId());

		if(gp!=null) {
			session.update(gp);
			session.getTransaction().commit();
		}
	}

	@Override
	public void showDetail(int id) {
		// TODO Auto-generated method stub
		if(getById(id)!=null) {
			Groupe gp = getById(id);
			System.out.println(gp.toString());
		}
	}

	@Override
	public void showAll() {
		// TODO Auto-generated method stub
		if(groupes.isEmpty()) {
	    	System.out.println("Aucune donnée n'a été enregistré");
	    }
	    else 
	    {
	    	for(Groupe grp:groupes) {
	    		System.out.println("ID:"+grp.getGroupeId()+" Nom:"+grp.getNomGroupe());
	    	}
	   	}
	}

	@Override
	public List<Groupe> findAll() {
		// TODO Auto-generated method stub
		return groupes;
	}

	@Override
	public Groupe getById(int id) {
		// TODO Auto-generated method stub
		try {
			Groupe gp = session.get(Groupe.class, id);
			if(gp!=null) {
				return gp;
			}
			else {
				return null;
			}
		}
		catch(NullPointerException ex) {
			System.out.println("Groupe idinsponible :"+ex.getMessage());
			return null;
		}
	}

}

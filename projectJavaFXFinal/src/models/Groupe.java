package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import javax.persistence.OneToMany;

@Entity
@Table(name="groupe")
public class Groupe {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int groupeId;
	
	@Column(name="nom_groupe")
	private String nomGroupe;
	
	//Add Annotation mapping
	@OneToMany(mappedBy="groupe",cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST})
    private List<Etudiant> etudiants;

	public Groupe() {
		
	}
	public Groupe(String nomGroupe) {
		this.nomGroupe = nomGroupe;
	}
	
	public Groupe(String nomGroupe,List<Etudiant> et) {
		this.nomGroupe = nomGroupe;
		this.etudiants=et;
		
	}


	public String getNomGroupe() {
		return nomGroupe;
	}


	public void setNomGroupe(String nomGroupe) {
		this.nomGroupe = nomGroupe;
	}


	public List<Etudiant> getEtudiants() {
		return etudiants;
	}


	public void setEtudiants(List<Etudiant> etudiantGroupe) {
		this.etudiants = etudiantGroupe;
	}


	public int getGroupeId() {
		return groupeId;
	}
	
	
	//add convenience method for Bi-Directionnal relationship
/*
	public void add(Etudiant etudiant) {
		if(etudiants==null) {
			etudiants = new ArrayList<>();
		}
		else {
			etudiants.add(etudiant);
			etudiant.setGroupe(this);
		}
	}
	*/

	@Override
	public String toString() {
		return "Groupe [Id: " + groupeId + ", Nom: " + nomGroupe + "]";
	}
		
		
}

package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="professeur")
public class Professeur {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="matricule")
	private String matricule;
	
	@Column(name="genre")
	private String genre;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="prenom")
	private String prenom;
	
	@Column(name="adresse")
	private String adresse;
	
	@Column(name="date_naissance")
	private String dateNaissance;
	
	@Column(name="lieu_naissance")
	private String lieuNaissance;
	
	@Column(name="nationalite")
	private String nationalite;
	
	@Column(name="situation_matrimoniale")
	private String situationMatrimoniale;
	
	@Column(name="tel")
	private String tel;
	
	@Column(name="email")
	private String email;
	
	@Column(name="speciality")
	private String speciality;

	public Professeur() {
		
	}
	
	public Professeur(String matricule, String genre, String nom, String prenom, String adresse, String dateNaissance,
			String lieuNaissance, String nationalite, String situationMatrimoniale, String tel, String email,
			String speciality) {
		super();
		this.matricule = matricule;
		this.genre = genre;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.dateNaissance = dateNaissance;
		this.lieuNaissance = lieuNaissance;
		this.nationalite = nationalite;
		this.situationMatrimoniale = situationMatrimoniale;
		this.tel = tel;
		this.email = email;
		this.speciality = speciality;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getLieuNaissance() {
		return lieuNaissance;
	}

	public void setLieuNaissance(String lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
	}

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public String getSituationMatrimoniale() {
		return situationMatrimoniale;
	}

	public void setSituationMatrimoniale(String situationMatrimoniale) {
		this.situationMatrimoniale = situationMatrimoniale;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public int getId() {
		return id;
	}
	
	
}

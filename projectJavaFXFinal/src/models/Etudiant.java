package models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="etudiant")
public class Etudiant {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int etudiantId;
	
	@OneToOne(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST})
	@JoinColumn(name="groupe_id")
	private Groupe groupe;
	

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
	
	@Column(name="groupe_sanguin")
	private String groupeSanguin;

	public Etudiant() {
		
	}
	public Etudiant(String matricule, String genre, String nom, String prenom, String adresse, String dateNaissance,
			String lieuNaissance, String nationalite, String situationMatrimoniale, String tel, String email,
			String groupeSanguin) {
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
		this.groupeSanguin = groupeSanguin;
	}

	
	public int getEtudiantId() {
		return etudiantId;
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

	public String getGroupeSanguin() {
		return groupeSanguin;
	}

	public void setGroupeSanguin(String groupeSanguin) {
		this.groupeSanguin = groupeSanguin;
	}
	public Groupe getGroupe() {
		return groupe;
	}
	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}
	@Override
	public String toString() {
		return "Etudiant [matricule=" + matricule + ", genre=" + genre + ", nom=" + nom + ", prenom=" + prenom
				+ ", adresse=" + adresse + ", dateNaissance=" + dateNaissance + ", lieuNaissance=" + lieuNaissance
				+ ", nationalite=" + nationalite + ", situationMatrimoniale=" + situationMatrimoniale + ", tel=" + tel
				+ ", email=" + email + ", groupeSanguin=" + groupeSanguin + "]";
	}
	
	
	
	
}

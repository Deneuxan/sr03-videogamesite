package beans;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;

public class Client implements Serializable, Comparable<Client> {
	
	private int id_client;
	private String username;
	private String password;
	private String nom;
	private String prenom;
	private String gender;
	private Date date_naissance;
	
	public Client() {
		
	}
	
	public Client(int id_client, String username, String password, String nom, String prenom, String gender, Date date_naissance) {
		super();
		this.id_client = id_client;
		this.username = username;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.gender = gender;
		this.date_naissance = date_naissance;	
		
	}
	
	public int getId_client() {
		return id_client;
	}
	public void setId_client(int id_client) {
		this.id_client = id_client;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) throws Exception{
		if(password.length()<4)
			throw new Exception("Erreur : longeur de mot de passe <4");
		else
			this.password = password;	
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
	
	/*this.gender = gender;
	this.date_naissance = date_naissance;*/	
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public Date getDate_naissance() {
		return date_naissance;
	}
	public void setDate_naissance(Date date_naissance) {
		this.date_naissance = date_naissance;
	}

	@Override
	public int compareTo(Client o) {
		return this.username.compareTo(o.username);
	}
	

}

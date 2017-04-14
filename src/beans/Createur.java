package beans;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;

public class Createur implements Serializable{
	
	private int id_createur;
	private String nom;
	private String description_createur;
	
	public Createur() {
		
	}

	public Createur(int id_createur, String nom, String description_createur) {
		super();
		this.id_createur = id_createur;
		this.nom = nom;
		this.description_createur = description_createur;
		
	}
	
	public int getId_createur() {
		return id_createur;
	}
	public void setId_createur(int id_createur) {
		this.id_createur = id_createur;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getDescription_createur() {
		return description_createur;
	}
	public void setDescription_createur(String description_createur) {
		this.description_createur = description_createur;
	}
}

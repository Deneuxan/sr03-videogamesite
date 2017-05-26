package beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Jeux implements Serializable, Comparable<Jeux>{

	private int id_jeux;
	private String titre;
	private String photo_jeux;
	private String type_console;
	private float tarif;
	private int nombre_libre;
	private int id_createur;
	private String description_jeux;
	private String type_livraison;
	private boolean a_vendre;
	private Date date_publication;
	private int nombre_achete;
	
	public Jeux() {
		
	}
	
	public Jeux(int id_jeux, String titre, String photo_jeux, String type_console, float tarif, int nombre_libre, int id_createur,String description_jeux, String type_livraison, boolean a_vendre, Date date_publication) {
		super();
		this.id_jeux = id_jeux;
		this.titre = titre;
		this.photo_jeux = photo_jeux;
		this.type_console = type_console;
		this.tarif = tarif;
		this.nombre_libre = nombre_libre;
		this.id_createur = id_createur;
		this.description_jeux = description_jeux;
		this.type_livraison = type_livraison;
		this.a_vendre = a_vendre;
		this.date_publication = date_publication;	
		
	}
	
	public int getId_jeux() {
		return id_jeux;
	}
	public void setId_jeux(int id_jeux) {
		this.id_jeux = id_jeux;
	}
	
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	public String getPhoto_jeux() {
		return photo_jeux;
	}
	public void setPhoto_jeux(String photo_jeux) {
		this.photo_jeux = photo_jeux;
	}
	
	public String getType_console() {
		return type_console;
	}
	public void setType_console(String type_console) {
		this.type_console = type_console;
	}
	
	public float getTarif() {
		return tarif;
	}
	public void setTarif(float tarif) {
		this.tarif = tarif;
	}
	
	public int getNombre_libre() {
		return nombre_libre;
	}
	public void setNombre_libre(int nombre_libre) {
		this.nombre_libre = nombre_libre;
	}
	
	public int getid_createur() {
		return id_createur;
	}
	public void setid_createur(int id_createur) {
		this.id_createur = id_createur;
	}
	
	public String getDescription_jeux() {
		return description_jeux;
	}
	public void setDescription_jeux(String description_jeux) {
		this.description_jeux = description_jeux;
	}
	
	public String getType_livraison() {
		return type_livraison;
	}
	public void setType_livraison(String type_livraison) {
		this.type_livraison = type_livraison;
	}
	
	public boolean getA_vendre() {
		return a_vendre;
	}
	public void setA_vendre(boolean a_vendre) {
		this.a_vendre = a_vendre;
	}
	
	public Date getDate_publication() {
		return date_publication;
	}
	public void setDate_publication(Date date_publication) {
		this.date_publication = date_publication;
	}
	
	public int getNombre_achete() {
		return nombre_achete;
	}
	public void setNombre_achete(int nombre_achete) {
		this.nombre_achete = nombre_achete;
	}
	
	public String ToJSON()
	{
		String jsonInString = "";
		ObjectMapper mapper = new ObjectMapper();
		//Object to JSON in String
		try {
			jsonInString = mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonInString;
	}
	
	static public String ToJSONall(List<Jeux> list){
		String jsonInString = "";
		ObjectMapper mapper = new ObjectMapper();
		//Object to JSON in String
		try {
			jsonInString = mapper.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonInString;
		
	}
	
	
	@Override
	public int compareTo(Jeux o) {
		// TODO Auto-generated method stub
		return 0;
	}

}

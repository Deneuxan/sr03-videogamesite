package beans;

import java.io.Serializable;
import java.util.Date;

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
		this.nombre_libre = id_createur;
		this.description_jeux = description_jeux;
		this.type_livraison = type_livraison;
		this.a_vendre = a_vendre;
		this.date_publication = date_publication;	
		
	}
	
	/*public int getId_jeux() {
		return id_jeux;
	}
	public void setId_jeux(int id_jeux) {
		this.id_jeux = id_jeux;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	*/
	
	@Override
	public int compareTo(Jeux o) {
		// TODO Auto-generated method stub
		return 0;
	}

}

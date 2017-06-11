package beans;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;


public class Command_jeux_union {
	
	/*private Commande_detail Commande_detail = null;
	private Jeux Jeux = null;*/
	
	private int id_commande_detail;
	private int id_commande;
	private int id_jeux;
	private int nombre;
	private String titre;
	private String photo_jeux;
	private float tarif;
	
	public Command_jeux_union(int id_commande_detail, int id_commande,int id_jeux, int nombre, String titre, String photo_jeux, float tarif) {
		super();
		this.id_commande_detail = id_commande_detail;
		this.id_commande = id_commande;
		this.id_jeux = id_jeux;
		this.nombre = nombre;
		this.titre = titre;
		this.photo_jeux = photo_jeux;
		this.tarif = tarif;
	}
	
	public int getId_commande_detail() {
		return id_commande_detail;
	}
	public void setId_commande_detail(int id_commande_detail) {
		this.id_commande_detail = id_commande_detail;
	}
	
	public int getId_commande() {
		return id_commande;
	}
	public void setId_commande(int id_commande) {
		this.id_commande = id_commande;
	}
	
	public int getId_jeux() {
		return id_jeux;
	}
	public void setId_jeux(int id_jeux) {
		this.id_jeux = id_jeux;
	}
	
	public int getNombre() {
		return nombre;
	}
	public void setNombre(int nombre) {
		this.nombre = nombre;
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
	
	public float getTarif() {
		return tarif;
	}
	public void setTarif(float tarif) {
		this.tarif = tarif;
	}

}

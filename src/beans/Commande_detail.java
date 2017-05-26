package beans;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;


public class Commande_detail implements Serializable, Comparable<Commande_detail>{
	
	private int id_commande_detail;
	private int id_commande;
	private int id_jeux;
	private int nombre;
	
	public Commande_detail(int id_commande_detail, int id_commande,int id_jeux, int nombre ) {
		super();
		this.id_commande_detail = id_commande_detail;
		this.id_commande = id_commande;
		this.id_jeux = id_jeux;
		this.nombre = nombre;
		
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
	

	@Override
	public int compareTo(Commande_detail o) {
		// TODO Auto-generated method stub
		return 0;
	}

}

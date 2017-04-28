package beans;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;


public class Commande implements Serializable, Comparable<Commande>{
	
	private int id_client;
	private int id_commande;
	private Date date_valide;
	private float somme_argent;
	private int id_address;
	
	
	public int getId_client() {
		return id_client;
	}
	public void setId_client(int id_client) {
		this.id_client = id_client;
	}
	
	public int getId_commande() {
		return id_commande;
	}
	public void setId_commande(int id_commande) {
		this.id_commande = id_commande;
	}
	
	public Date getDate_valide() {
		return date_valide;
	}
	public void setDate_valide(Date date_valide) {
		this.date_valide = date_valide;
	}
	
	
	public float getSomme_argent() {
		return somme_argent;
	}
	public void setSomme_argent(float somme_argent) {
		this.somme_argent = somme_argent;
	}
	
	public int getId_address() {
		return id_address;
	}
	public void setId_address(int id_address) {
		this.id_address = id_address;
	}
	
	
	
	@Override
	public int compareTo(Commande o) {
		// TODO Auto-generated method stub
		return 0;
	}

}

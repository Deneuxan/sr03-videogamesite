package beans;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;

public class Client_address implements Serializable, Comparable<Client_address>{
	
	private int id_client;
	private int id_address;
	private String recepteur;
	private String address;
	private String code_postal;
	private String ville;
	private String pays;
	private String telephone;
	
	public Client_address() {
			
		}
	
	public Client_address(int id_client, int id_address, String recepteur, String address, String code_postal, String ville, String pays, String telephone) {
		super();
		this.id_client = id_client;
		this.id_address = id_address;
		this.recepteur = recepteur;
		this.address = address;
		this.code_postal = code_postal;
		this.ville = ville;
		this.pays = pays;
		this.telephone = telephone;	
		
	}
	public int getId_client() {
		return id_client;
	}
	public void setId_client(int id_client) {
		this.id_client = id_client;
	}
	
	public int getId_address() {
		return id_address;
	}
	public void setId_address(int id_address) {
		this.id_address = id_address;
	}
	
	public String getRecepteur() {
		return recepteur;
	}
	public void setRecepteur(String recepteur) {
		this.recepteur = recepteur;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getCode_postal() {
		return code_postal;
	}
	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}
	
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	
	public String getTelephone() {
		return telephone;
	}
	public void setTelephones(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public int compareTo(Client_address o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}

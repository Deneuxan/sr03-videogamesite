package beans;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Commentaire implements Serializable, Comparable<Commentaire>{
	
	private int id_client;
	private int id_commande;
	private int  id_address;
	private float somme_argent;
	private Date date_valide;
	
	public Commentaire() {
		
	}
	
	public Commentaire(int id_client, int id_commande, int id_address, float somme_argent,  Date date_valide) {
		super();
		this.id_client = id_client;
		this.id_commande = id_commande;
		this.id_address = id_address;
		this.somme_argent = somme_argent;
		this.date_valide = date_valide;
		
	}
	
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
	
	public int getId_address() {
		return id_address;
	}
	public void setId_address(int id_address) {
		this.id_address = id_address;
	}
	
	public float getSomme_argent() {
		return somme_argent;
	}
	public void setSomme_argent(float somme_argent) {
		this.somme_argent = somme_argent;
	}
	
	public Date getDate_valide() {
		return date_valide;
	}
	public void setDate_valide(Date date_valide) {
		this.date_valide = date_valide;
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
	
	static public String ToJSONall(List<Client> list){
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
	public int compareTo(Commentaire o) {
		// TODO Auto-generated method stub
		return 0;
	}

}

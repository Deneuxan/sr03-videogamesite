package beans;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Categorie implements Serializable, Comparable<Categorie>{
	
	private int id_categorie;
	private String nom_categorie;
	private String description_categorie;

	public Categorie() {
			
		}
	
	public Categorie(int id_categorie, String nom_categorie, String description_categorie) {
		super();
		this.id_categorie = id_categorie;
		this.nom_categorie = nom_categorie;
		this.description_categorie = description_categorie;		
	}
	
	public int getId_categorie() {
		return id_categorie;
	}
	public void setId_categorie(int id_categorie) {
		this.id_categorie = id_categorie;
	}
	
	public String getNom_categorie() {
		return nom_categorie;
	}
	public void setNom_categorie(String nom_categorie) {
		this.nom_categorie = nom_categorie;
	}
	
	public String getDescription_categorie() {
		return description_categorie;
	}
	public void setDescription_categorie(String description_categorie) {
		this.description_categorie = description_categorie;
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
	public int compareTo(Categorie o) {
		// TODO Auto-generated method stub
		return 0;
	}

}

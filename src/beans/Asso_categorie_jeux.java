package beans;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Asso_categorie_jeux implements Serializable, Comparable<Asso_categorie_jeux>{
	
	private int id_categorie;
	private int id_jeux;

	public Asso_categorie_jeux() {
			
		}
	
	public Asso_categorie_jeux(int id_categorie, int id_jeux) {
		super();
		this.id_categorie = id_categorie;
		this.id_jeux = id_jeux;
	
	}
	
	public int getId_categorie() {
		return id_categorie;
	}
	public void setId_categorie(int id_categorie) {
		this.id_categorie = id_categorie;
	}
	
	public int getId_jeux() {
		return id_jeux;
	}
	public void setId_jeux(int id_jeux) {
		this.id_jeux = id_jeux;
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
	public int compareTo(Asso_categorie_jeux o) {
		// TODO Auto-generated method stub
		return 0;
	}

}

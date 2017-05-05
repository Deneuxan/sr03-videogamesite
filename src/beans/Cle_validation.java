package beans;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Cle_validation implements Serializable, Comparable<Cle_validation>{
	
	private int id_jeux;
	private int id_commande_detail;
	private String  cle;
	
public Cle_validation() {
		
	}
	
	public Cle_validation(int id_jeux, int id_commande_detail, String cle) {
		super();
		this.id_jeux = id_jeux;
		this.id_commande_detail = id_commande_detail;
		this.cle = cle;	
	}
	
	public int getId_jeux() {
		return id_jeux;
	}
	public void setId_jeux(int id_jeux) {
		this.id_jeux = id_jeux;
	}
	
	public int getId_commande_detail() {
		return id_commande_detail;
	}
	public void setId_commande_detail(int id_commande_detail) {
		this.id_commande_detail = id_commande_detail;
	}
	
	public String getCle() {
		return cle;
	}
	public void setCle(String cle) {
		this.cle = cle;
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
	public int compareTo(Cle_validation o) {
		// TODO Auto-generated method stub
		return 0;
	}

}

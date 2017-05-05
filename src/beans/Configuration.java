package beans;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Configuration implements Serializable, Comparable<Configuration> {
	
	private int id_jeux;
	private int id_configuration;
	private String OS;
	private String CPU;
	private String RAM;
	private String GPU;
	private String HDD;
	
	public Configuration() {
			
		}
	
	public Configuration(int id_jeux, int id_configuration,String OS, String CPU, String RAM, String GPU, String HDD) {
		super();
		this.id_jeux = id_jeux;
		this.id_configuration = id_configuration;
		this.OS = OS;
		this.CPU = CPU;
		this.RAM = RAM;
		this.GPU = GPU;
		this.HDD = HDD;			
	}
	
	
	public int getId_jeux() {
		return id_configuration;
	}
	public void setId_jeux(int id_configuration) {
		this.id_configuration = id_configuration;
	}
	
	public int getId_configuration() {
		return id_jeux;
	}
	public void setId_configuration(int id_jeux) {
		this.id_jeux = id_jeux;
	}
	
	public String getOS() {
		return OS;
	}
	public void setOS(String OS) {
		this.OS = OS;
	}
	
	public String getCPU() {
		return CPU;
	}
	public void setCPU(String CPU) {
		this.CPU = CPU;
	}

	public String getRAM() {
		return RAM;
	}
	public void setRAM(String RAM) {
		this.RAM = RAM;
	}
	
	public String getGPU() {
		return GPU;
	}
	public void setGPU(String GPU) {
		this.GPU = GPU;
	}
	
	public String getHDD() {
		return HDD;
	}
	public void setHDD(String HDD) {
		this.HDD = HDD;
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
	public int compareTo(Configuration o) {
		// TODO Auto-generated method stub
		return 0;
	}

}



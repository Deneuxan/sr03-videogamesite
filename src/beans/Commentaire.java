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
	
	private int id_jeux;
	private int id_client;
	private float score;
	private String  commentaire;
	private Date date_commentaire;
	private String username;
	
	public Commentaire() {
		
	}
	
	public Commentaire(int id_jeux, int id_client, float score, String commentaire,  Date date_commentaire, String username) {
		super();
		this.id_client = id_client;
		this.id_jeux = id_jeux;
		this.score = score;
		this.commentaire = commentaire;
		this.date_commentaire = date_commentaire;
		this.username = username;		
	}
	
	public int getId_client() {
		return id_client;
	}
	public void setId_client(int id_client) {
		this.id_client = id_client;
	}
	
	public int getId_jeux() {
		return id_jeux;
	}
	public void setId_jeux(int id_jeux) {
		this.id_jeux = id_jeux;
	}
	
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	
	public Date getDate_commentaire() {
		return date_commentaire;
	}
	public void setDate_commentaire(Date date_commentaire) {
		this.date_commentaire = date_commentaire;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String address) {
		this.username = username;
	}
	
	
	@Override
	public int compareTo(Commentaire o) {
		// TODO Auto-generated method stub
		return 0;
	}

}

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import beans.Categorie;
import beans.Cle_validation;
import beans.Client;
import beans.Client_address;
import beans.Commande;
import beans.Commande_detail;
import beans.Commentaire;
import beans.Configuration;
import beans.Createur;
import hibernate_beans.ClientAddress;
import hibernate_beans.ClientAddressId;
import beans.Jeux;


public class GestionJeuxBDD {
	
public static int updateAchatJeux(int id_jeux, int nb) {
	int res = 0;
	
	Connection cnx=null;
	
	try {
		// chargement du driver
		cnx = ConnexionBDD.getInstance().getCnx();
		
		//Requete
		String sql = "UPDATE jeux SET nombre_achete=nombre_achete+? WHERE id_jeux=?";
		PreparedStatement ps = cnx.prepareStatement(sql);
		ps.setInt(1, nb);
		ps.setInt(2, id_jeux);
		
		//Execution et traitement de la r��ponse
		res = ps.executeUpdate();
		
		ConnexionBDD.getInstance().closeCnx();			
	} catch (SQLException e) {
		e.printStackTrace();
	}

	return res;
}


public static List<Categorie> findAllCategorie() {
		
		List<Categorie> lu = new ArrayList<Categorie>();
		Connection cnx=null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());
			
			//Requete
			String sql = "select id_categorie, nom_categorie, description_categorie from categorie;";
			PreparedStatement ps = cnx.prepareStatement(sql);
			
			//Execution et traitement de la réponse
			ResultSet res = ps.executeQuery();
			
			while(res.next()){
				lu.add(new Categorie(res.getInt("id_categorie"),
						res.getString("nom_categorie"),
						res.getString("description_categorie")	
						));
			}
			
			res.close();
			ConnexionBDD.getInstance().closeCnx();			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//

		return lu;
	}
	
	
	public static Categorie findCategorie(int id) {
		
		Categorie u = null;
		
		Connection cnx=null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());

		
			//Requete
			String sql = "select id_categorie, nom_categorie, description_categorie from categorie where id_categorie=?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, id);
			
			
			//Execution et traitement de la r��ponse
			ResultSet res = ps.executeQuery();
			
			while(res.next()){
				u = new Categorie(res.getInt("id_categorie"),
						res.getString("nom_categorie"),
						res.getString("description_categorie")	
						);
				break;
			}
			
			res.close();
			ConnexionBDD.getInstance().closeCnx();			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//

		return u;
	}
	
	
public static List<Jeux> findCategorieAllJeux(int id) {
		
		List<Jeux> lu = new ArrayList<Jeux>();
		Connection cnx=null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());
			
			//Requete
			String sql = "select jeux.id_jeux, titre, photo_jeux,type_console,tarif,nombre_libre,id_createur,description_jeux,type_livraison,a_vendre,date_publication from jeux,asso_categorie_jeux where a_vendre=1 and asso_categorie_jeux.id_jeux=jeux.id_jeux and id_categorie=? order by nombre_achete desc;";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, id);
			
			//Execution et traitement de la réponse
			ResultSet res = ps.executeQuery();
			
			while(res.next()){
				lu.add(new Jeux(res.getInt("id_jeux"),
						res.getString("titre"),
						res.getString("photo_jeux"),
						res.getString("type_console"),
						res.getFloat("tarif"),
						res.getInt("nombre_libre"),
						res.getInt("id_createur"),
						res.getString("description_jeux"),
						res.getString("type_livraison"),
						res.getBoolean("a_vendre"),
						res.getDate("date_publication")		
						));
			}
			
			res.close();
			ConnexionBDD.getInstance().closeCnx();			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//

		return lu;
	}

public static Configuration findConfiguration(int id) {
	
	Configuration u = null;
	
	Connection cnx=null;
	try {
		cnx = ConnexionBDD.getInstance().getCnx();
		// ou Class.forName(com.mysql.jdbc.Driver.class.getName());

	
		//Requete
		String sql = "select id_jeux, id_configuration, OS, CPU, RAM, GPU, HDD from configuration where id_jeux=?";
		PreparedStatement ps = cnx.prepareStatement(sql);
		ps.setInt(1, id);
		
		
		//Execution et traitement de la r��ponse
		ResultSet res = ps.executeQuery();
		
		while(res.next()){
			u = new Configuration(res.getInt("id_jeux"),res.getInt("id_configuration"),
					res.getString("OS"),res.getString("CPU"),res.getString("RAM"),res.getString("GPU"),
					res.getString("HDD")	
					);
			break;
		}
		
		res.close();
		ConnexionBDD.getInstance().closeCnx();			
	} catch (SQLException e) {
		e.printStackTrace();
	}

	//

	return u;
}


public static Createur findCreateur(int id) {
	
	Createur u = null;
	
	Connection cnx=null;
	try {
		cnx = ConnexionBDD.getInstance().getCnx();
		// ou Class.forName(com.mysql.jdbc.Driver.class.getName());

	
		//Requete
		String sql = "select id_createur, nom, description_createur from createur where id_createur=?";
		PreparedStatement ps = cnx.prepareStatement(sql);
		ps.setInt(1, id);
		
		
		//Execution et traitement de la r��ponse
		ResultSet res = ps.executeQuery();
		
		while(res.next()){
			u = new Createur(res.getInt("id_createur"),
					res.getString("nom"),
					res.getString("description_createur")	
					);
			break;
		}
		
		res.close();
		ConnexionBDD.getInstance().closeCnx();			
	} catch (SQLException e) {
		e.printStackTrace();
	}

	//

	return u;
}

public static List<Commentaire> findCommentaire(int id) {
	
	List<Commentaire> lu = new ArrayList<Commentaire>();
	Connection cnx=null;
	try {
		cnx = ConnexionBDD.getInstance().getCnx();
		// ou Class.forName(com.mysql.jdbc.Driver.class.getName());
		
		//Requete
		String sql = "SELECT id_jeux,client.id_client,score,commentaire,date_commentaire,username FROM client,commentaire where client.id_client=commentaire.id_client and id_jeux=? order by date_commentaire;";
		PreparedStatement ps = cnx.prepareStatement(sql);
		ps.setInt(1, id);
		
		//Execution et traitement de la réponse
		ResultSet res = ps.executeQuery();
		
		while(res.next()){
			lu.add(new Commentaire(res.getInt("id_jeux"),
					res.getInt("id_client"),
					res.getFloat("score"),
					res.getString("commentaire"),
					res.getDate("date_commentaire"),
					res.getString("username")							
					));
		}
		
		res.close();
		ConnexionBDD.getInstance().closeCnx();			
	} catch (SQLException e) {
		e.printStackTrace();
	}

	//

	return lu;
}
	
public static int insertCommentaire(Commentaire u) {
	int res = 0;
			
	Connection cnx=null;
	try {
		cnx = ConnexionBDD.getInstance().getCnx();
		
		//Requete
		String sql = "INSERT INTO commentaire(id_jeux, id_client, score, commentaire) " +
				"VALUES(?,?,?,?)";
		PreparedStatement ps = cnx.prepareStatement(sql);
		ps.setInt(1, u.getId_jeux());
		ps.setInt(2, u.getId_client());
		ps.setFloat(3, u.getScore());
		ps.setString(4, u.getCommentaire());	
	
		//Execution et traitement de la r��ponse
		res = ps.executeUpdate();
		
		ConnexionBDD.getInstance().closeCnx();			
	} catch (SQLException e) {
		e.printStackTrace();
	}

	return res;
}

public static List<Cle_validation> findCle_validation(int id, int nombre) {
	
	List<Cle_validation> lu = new ArrayList<Cle_validation>();
	Connection cnx=null;
	try {
		cnx = ConnexionBDD.getInstance().getCnx();
		// ou Class.forName(com.mysql.jdbc.Driver.class.getName());
		
		//Requete
		String sql = "SELECT id_jeux,cle FROM cle_validation where id_commande_detail is null and id_jeux=? limit ?;";
		PreparedStatement ps = cnx.prepareStatement(sql);
		ps.setInt(1, id);
		ps.setInt(2, nombre);
		
		//Execution et traitement de la réponse
		ResultSet res = ps.executeQuery();
		
		while(res.next()){
			lu.add(new Cle_validation(res.getInt("id_jeux"),0,
					res.getString("cle")));
		}
		
		res.close();
		ConnexionBDD.getInstance().closeCnx();			
	} catch (SQLException e) {
		e.printStackTrace();
	}

	//

	return lu;
}



public static List<Cle_validation> SendCle_validation(int id, int id_commande_detail) {
	
	List<Cle_validation> lu = new ArrayList<Cle_validation>();
	Connection cnx=null;
	try {
		cnx = ConnexionBDD.getInstance().getCnx();
		// ou Class.forName(com.mysql.jdbc.Driver.class.getName());
		
		//Requete
		String sql = "SELECT id_jeux,cle,id_commande_detail FROM cle_validation where id_jeux=? and id_commande_detail=?;";
		PreparedStatement ps = cnx.prepareStatement(sql);
		ps.setInt(1, id);
		ps.setInt(2, id_commande_detail);
		
		//Execution et traitement de la réponse
		ResultSet res = ps.executeQuery();
		
		while(res.next()){
			lu.add(new Cle_validation(res.getInt("id_jeux"),res.getInt("id_commande_detail"),
					res.getString("cle")));
		}
		
		res.close();
		ConnexionBDD.getInstance().closeCnx();			
	} catch (SQLException e) {
		e.printStackTrace();
	}

	//

	return lu;
}

public static int updateCle_validation(Cle_validation u) {
	int res = 0;
	
	Connection cnx=null;
	
	try {
		// chargement du driver
		cnx = ConnexionBDD.getInstance().getCnx();
		
		//Requete
		String sql = "UPDATE cle_validation SET id_commande_detail=? WHERE id_jeux=? and cle=?";
		PreparedStatement ps = cnx.prepareStatement(sql);
		ps.setInt(1, u.getId_commande_detail());
		ps.setInt(2, u.getId_jeux());
		ps.setString(3, u.getCle());
		
		//Execution et traitement de la r��ponse
		res = ps.executeUpdate();
		
		ConnexionBDD.getInstance().closeCnx();			
	} catch (SQLException e) {
		e.printStackTrace();
	}

	return res;
}




}

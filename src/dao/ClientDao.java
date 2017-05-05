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

import beans.Client;

public class ClientDao {
	
	public static List<Client> findAll() {
		/*
		 * List<beans.Client> lu = new ArrayList<Client>(); lu.add(new
		 * Client(1,"nom1","tel1","username1","pwd1")); lu.add(new
		 * Client(2,"nom2","tel2","username2","pwd2")); lu.add(new
		 * Client(3,"nom3","tel3","username3","pwd3"));
		 */

		List<Client> lu = new ArrayList<Client>();
		Connection cnx=null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());
			
			//Requete
			String sql = "SELECT id_client,username,password,nom,prenom,gender,date_naissance FROM client;";
			PreparedStatement ps = cnx.prepareStatement(sql);
			
			//Execution et traitement de la réponse
			ResultSet res = ps.executeQuery();
			
			while(res.next()){
				lu.add(new Client(res.getInt("id_client"),
						res.getString("username"),
						res.getString("password"),
						res.getString("nom"),
						res.getString("prenom"),
						res.getString("gender"),
						res.getDate("date_naissance")		
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
	
	public static int insert(Client u) {
		int res = 0;
				
		Connection cnx=null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			
			//Requete
			String sql = "INSERT INTO client(username,password,nom,prenom,gender,date_naissance) " +
					"VALUES(?,?,?,?,?,?)";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getNom());
			ps.setString(4, u.getPrenom());
			ps.setString(5, u.getGender());
			if(u.getDate_naissance()==null){
				ps.setDate(6, null);}
			else{
				ps.setDate(6, new java.sql.Date(u.getDate_naissance().getTime()));}
			
			//Execution et traitement de la r��ponse
			res = ps.executeUpdate();
			
			ConnexionBDD.getInstance().closeCnx();			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}
	
	public static int update(Client u) {
		int res = 0;
		
		Connection cnx=null;
		
		try {
			// chargement du driver
			cnx = ConnexionBDD.getInstance().getCnx();
			
			//Requete
			String sql = "UPDATE client SET password=?,nom=?,prenom=?,gender=?,date_naissance=? WHERE id_client=?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setString(1, u.getPassword());
			ps.setString(2, u.getNom());
			ps.setString(3, u.getPrenom());
			ps.setString(4, u.getGender());			
			ps.setDate(5, new java.sql.Date(u.getDate_naissance().getTime()));
			ps.setInt(6, u.getId_client());
			
			//Execution et traitement de la r��ponse
			res = ps.executeUpdate();
			
			ConnexionBDD.getInstance().closeCnx();			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}
	
	public static int delete(int id) {
		int res = 0;
		Connection cnx=null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			// ou Class.forName(com.umysql.jdbc.Driver.class.getName());

				
			//Requete
			String sql = "DELETE FROM client WHERE id_client=?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1,id);
			
			//Execution et traitement de la r��ponse
			res = ps.executeUpdate();
			
			ConnexionBDD.getInstance().closeCnx();			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}
	
	public static Client find(int id) {
		/*
		 * List<beans.Client> lu = new ArrayList<Client>(); lu.add(new
		 * Client(1,"nom1","tel1","username1","pwd1")); lu.add(new
		 * Client(2,"nom2","tel2","username2","pwd2")); lu.add(new
		 * Client(3,"nom3","tel3","username3","pwd3"));
		 */

		Client u = null;
		
		Connection cnx=null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());

		
			//Requete
			String sql = "SELECT id_client,username,password,nom,prenom,gender,date_naissance FROM client WHERE id_client=?;";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, id);
			
			
			//Execution et traitement de la r��ponse
			ResultSet res = ps.executeQuery();
			
			while(res.next()){
				u = new Client(res.getInt("id_client"),
					res.getString("username"),
					res.getString("password"),
					res.getString("nom"),
					res.getString("prenom"),
					res.getString("gender"),
					res.getDate("date_naissance")		
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
	
	
	public static Client find(String username) {
		/*
		 * List<beans.Client> lu = new ArrayList<Client>(); lu.add(new
		 * Client(1,"nom1","tel1","username1","pwd1")); lu.add(new
		 * Client(2,"nom2","tel2","username2","pwd2")); lu.add(new
		 * Client(3,"nom3","tel3","username3","pwd3"));
		 */

		Client u = null;
		
		Connection cnx=null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());

		
			//Requete
			String sql = "SELECT id_client,username,password,nom,prenom,gender,date_naissance FROM client WHERE username=?;";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setString(1, username);
			
			
			//Execution et traitement de la r��ponse
			ResultSet res = ps.executeQuery();
			
			while(res.next()){
				u = new Client(res.getInt("id_client"),
					res.getString("username"),
					res.getString("password"),
					res.getString("nom"),
					res.getString("prenom"),
					res.getString("gender"),
					res.getDate("date_naissance")		
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
	
	
	public static List<Client> findAll(int start, int nbElts) {
		/*
		 * List<beans.Client> lu = new ArrayList<Client>(); lu.add(new
		 * Client(1,"nom1","tel1","username1","pwd1")); lu.add(new
		 * Client(2,"nom2","tel2","username2","pwd2")); lu.add(new
		 * Client(3,"nom3","tel3","username3","pwd3"));
		 */

		List<Client> lu = new ArrayList<Client>();
		
		Connection cnx=null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());

		
			//Requete
			String sql = "SELECT id_client,username,password,nom,prenom,gender,date_naissance FROM client LIMIT ?,?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, nbElts);
			
			
			//Execution et traitement de la r��ponse
			ResultSet res = ps.executeQuery();
			
			while(res.next()){
				lu.add(new Client(res.getInt("id_client"),
					res.getString("username"),
					res.getString("password"),
					res.getString("nom"),
					res.getString("prenom"),
					res.getString("gender"),
					res.getDate("date_naissance")		
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
	
	public static Client check_client(Client u){
		
		Connection cnx=null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());

		
			//Requete
			String sql = "SELECT * FROM client WHERE username=? and password=?; ";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			
			//Execution et traitement de la r��ponse
			ResultSet res = ps.executeQuery();
			
			if (res.next()){ /*res.getRow() == 1*/
				u.setId_client(res.getInt("id_client"));
			}
			else{
				u = null;
			}		
			res.close();
			ConnexionBDD.getInstance().closeCnx();			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return u; 
	}
	
	public static int countUsers(){
		
		int counter = 0;
		Connection cnx=null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
		
			String sql = "SELECT COUNT(*) FROM Client";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ResultSet res = ps.executeQuery();
			
			while(res.next()){
			 counter = res.getInt("COUNT(*)");
			 break;
				
			}
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return counter;
	}

}

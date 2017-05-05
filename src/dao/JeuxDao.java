package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Client;
import beans.Jeux;

public class JeuxDao {
	
public static List<Jeux> findAll() {
		
		List<Jeux> lu = new ArrayList<Jeux>();
		Connection cnx=null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());
			
			//Requete
			String sql = "select id_jeux, titre, photo_jeux,type_console,tarif,nombre_libre,id_createur,description_jeux,type_livraison,a_vendre,date_publication from jeux;";
			PreparedStatement ps = cnx.prepareStatement(sql);
			
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
	
	
	public static Jeux find(int id) {
		
		Jeux u = null;
		
		Connection cnx=null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());

		
			//Requete
			String sql = "select id_jeux, titre, photo_jeux,type_console,tarif,nombre_libre,id_createur,description_jeux,type_livraison,a_vendre,date_publication from jeux where id_jeux=?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, id);
			
			
			//Execution et traitement de la r��ponse
			ResultSet res = ps.executeQuery();
			
			while(res.next()){
				u = new Jeux(res.getInt("id_jeux"),
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
	
	public static int delete(int id) {
		int res = 0;
		Connection cnx=null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			// ou Class.forName(com.umysql.jdbc.Driver.class.getName());

				
			//Requete
			String sql = "DELETE FROM jeux WHERE id_jeux=?";
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

	
	public static int insert(Jeux u) {
		int res = 0;
				
		Connection cnx=null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			
			//Requete
			String sql = "INSERT INTO jeux(titre,photo_jeux,type_console, tarif, nombre_libre, id_createur, description_jeux, a_vendre, type_livraison) " +
					"VALUES(?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setString(1, u.getTitre());
			ps.setString(2, u.getPhoto_jeux());
			ps.setString(3, u.getType_console());
			ps.setFloat(4, u.getTarif());
			ps.setInt(5, u.getNombre_libre());
			ps.setInt(6, u.getid_createur());
			ps.setString(7, u.getDescription_jeux());
			ps.setBoolean(8, u.getA_vendre());
			ps.setString(9, u.getType_livraison());	
			
			//Execution et traitement de la r��ponse
			res = ps.executeUpdate();
			
			ConnexionBDD.getInstance().closeCnx();			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}
	
	public static int update(Jeux u) {
		int res = 0;
		
		Connection cnx=null;
		
		try {
			// chargement du driver
			cnx = ConnexionBDD.getInstance().getCnx();
			
			//Requete
			String sql = "UPDATE jeux SET titre=?,photo_jeux=?,type_console=?,tarif=?,nombre_libre=?,id_createur=?, description_jeux=?,a_vendre=?,type_livraison=? WHERE id_jeux=?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setString(1, u.getTitre());
			ps.setString(2, u.getPhoto_jeux());
			ps.setString(3, u.getType_console());
			ps.setFloat(4, u.getTarif());
			ps.setInt(5, u.getNombre_libre());
			ps.setInt(6, u.getid_createur());
			ps.setString(7, u.getDescription_jeux());
			ps.setBoolean(8, u.getA_vendre());
			ps.setString(9, u.getType_livraison());
			ps.setInt(10, u.getId_jeux());
			
			//Execution et traitement de la r��ponse
			res = ps.executeUpdate();
			
			ConnexionBDD.getInstance().closeCnx();			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}
}

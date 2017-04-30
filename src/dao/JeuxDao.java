package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.Jeux;

public class JeuxDao {
	
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

}

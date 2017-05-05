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
import beans.Client_address;
import beans.Commande;
import hibernate_beans.ClientAddress;
import hibernate_beans.ClientAddressId;
/*import org.hibernate.SessionFactory;


import org.hibernate.Query;
import org.hibernate.Session;
import dao.HibernateUtil;
*/


public class GestionClientBDD {
	
	/*public static List<Client_address_address_address> findAllAdresse() {

		
		Session session = HibernateUtil.getSession();

        Query query = session.createQuery("from Client_address_address_address");
        query.setParameter("id", 5);
        
        List<Client_address_address_address> list = query.list();       

        System.out.println(list.get(0));
		return list;
	}*/
	
public static List<Client_address> findAllAddress(int id) {
		
		List<Client_address> lu = new ArrayList<Client_address>();
		Connection cnx=null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());
			
			//Requete
			String sql = "SELECT id_client,id_address,recepteur,address,code_postal,ville,pays,telephone FROM Client_address where id_client=? ;";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1,id);
			
			//Execution et traitement de la réponse
			ResultSet res = ps.executeQuery();
			
			while(res.next()){
				lu.add(new Client_address(res.getInt("id_client"),res.getInt("id_address"),
						res.getString("recepteur"),
						res.getString("address"),
						res.getString("code_postal"),
						res.getString("ville"),
						res.getString("pays"),
						res.getString("telephone")		
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
	
	public static int insertAddress(Client_address u) {
		int res = 0;
				
		Connection cnx=null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			
			//Requete
			String sql = "INSERT INTO Client_address(id_address, recepteur, address, code_postal, ville, pays, telephone) " +
					"VALUES(?,?,?,?,?,?,?)";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, u.getId_client());
			ps.setString(2, u.getRecepteur());
			ps.setString(3, u.getAddress());
			ps.setString(4, u.getCode_postal());
			ps.setString(5, u.getVille());
			ps.setString(6, u.getPays());
			ps.setString(7, u.getTelephone());
			res = ps.executeUpdate();
			
			ConnexionBDD.getInstance().closeCnx();			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}
	
	public static int updateAddress(Client_address u) {
		int res = 0;
		
		Connection cnx=null;
		
		try {
			// chargement du driver
			cnx = ConnexionBDD.getInstance().getCnx();
			
			//Requete
			String sql = "UPDATE Client_address SET recepteur=?,address=?,code_postal=?,ville=?,pays=?, telephone=? WHERE id_address=?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setString(1, u.getRecepteur());
			ps.setString(2, u.getAddress());
			ps.setString(3, u.getCode_postal());
			ps.setString(4, u.getVille());
			ps.setString(5, u.getPays());
			ps.setString(6, u.getTelephone());
			ps.setInt(7, u.getId_address());
			
			//Execution et traitement de la r��ponse
			res = ps.executeUpdate();
			
			ConnexionBDD.getInstance().closeCnx();			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}
	
	public static int deleteAddress(int id) {
		int res = 0;
		Connection cnx=null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			// ou Class.forName(com.umysql.jdbc.Driver.class.getName());

				
			//Requete
			String sql = "DELETE FROM Client_address WHERE id_address=?";
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
	
	
	
public static List<Commande> findAllCommande(int id) {
		
		List<Commande> lu = new ArrayList<Commande>();
		Connection cnx=null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());
			
			//Requete
			String sql = "select id_commande,date_valide,somme_argent,address,code_postal,ville,pays from commande,client_address where client_address.id_address=commande.id_address and id_client=?;";
			PreparedStatement ps = cnx.prepareStatement(sql);
			
			//Execution et traitement de la réponse
			ResultSet res = ps.executeQuery();
			
			/*while(res.next()){
				lu.add(new Commande(res.getInt("id_commande"),res.getDate("date_valide"),
						res.getFloat("somme_argent"),
						res.getString("address"),
						res.getString("code_postal"),
						res.getString("ville"),
						res.getString("pays")	
				));
			}*/
			
			res.close();
			ConnexionBDD.getInstance().closeCnx();			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//

		return lu;
	}
	
	
	

}

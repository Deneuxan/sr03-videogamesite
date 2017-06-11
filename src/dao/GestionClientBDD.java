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
import beans.Command_jeux_union;
import beans.Commande;
import beans.Commande_detail;
import beans.Jeux;
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
			String sql = "SELECT id_client,id_address,recepteur,address,code_postal,ville,pays,telephone FROM client_address where id_client=? ;";
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

	
public static Client_address findAddress(int client_id, int adresse_id) {
	
	Client_address lu = null;
	Connection cnx=null;
	try {
		cnx = ConnexionBDD.getInstance().getCnx();
		// ou Class.forName(com.mysql.jdbc.Driver.class.getName());
		
		//Requete
		String sql = "SELECT id_client,id_address,recepteur,address,code_postal,ville,pays,telephone FROM client_address where id_client=? and id_address=?;";
		PreparedStatement ps = cnx.prepareStatement(sql);
		ps.setInt(1,client_id);
		ps.setInt(2,adresse_id);
		
		//Execution et traitement de la réponse
		ResultSet res = ps.executeQuery();
		
		while(res.next()){
			lu = new Client_address(res.getInt("id_client"),res.getInt("id_address"),
					res.getString("recepteur"),
					res.getString("address"),
					res.getString("code_postal"),
					res.getString("ville"),
					res.getString("pays"),
					res.getString("telephone")		
			);
			break;
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
			String sql = "INSERT INTO client_address(id_client, recepteur, address, code_postal, ville, pays, telephone) " +
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
			String sql = "UPDATE client_address SET recepteur=?,address=?,code_postal=?,ville=?,pays=?, telephone=? WHERE id_address=? and id_client=?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setString(1, u.getRecepteur());
			ps.setString(2, u.getAddress());
			ps.setString(3, u.getCode_postal());
			ps.setString(4, u.getVille());
			ps.setString(5, u.getPays());
			ps.setString(6, u.getTelephone());
			ps.setInt(7, u.getId_address());
			ps.setInt(8, u.getId_client());
			
			//Execution et traitement de la r��ponse
			res = ps.executeUpdate();
			
			ConnexionBDD.getInstance().closeCnx();			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}
	
	public static int deleteAddress(int client_id, int adresse_id) {
		int res = 0;
		Connection cnx=null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			// ou Class.forName(com.umysql.jdbc.Driver.class.getName());

				
			//Requete
			String sql = "DELETE FROM client_address WHERE id_address=? and id_client=?;";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1,adresse_id);
			ps.setInt(2,client_id);
			
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
			String sql = "select id_client,id_commande,date_valide,somme_argent,address,somme_jeux from commande where commande.id_client=?;";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1,id);
			
			//Execution et traitement de la réponse
			ResultSet res = ps.executeQuery();
			
			while(res.next()){
				lu.add(new Commande(res.getInt("id_client"),res.getInt("id_commande"),
						res.getDate("date_valide"),res.getFloat("somme_argent"),
						res.getString("address"), res.getInt("somme_jeux")						
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


public static Commande findCommande(int id_client, int id_commande) {
	
	Commande lu = null;
	Connection cnx=null;
	try {
		cnx = ConnexionBDD.getInstance().getCnx();
		// ou Class.forName(com.mysql.jdbc.Driver.class.getName());
		
		//Requete
		String sql = "select id_client,id_commande,date_valide,somme_argent,address,somme_jeux from commande where commande.id_client=? and id_commande=?;";
		PreparedStatement ps = cnx.prepareStatement(sql);
		ps.setInt(1,id_client);
		ps.setInt(2,id_commande);
		
		//Execution et traitement de la réponse
		ResultSet res = ps.executeQuery();
		
		while(res.next()){
			lu = new Commande(res.getInt("id_client"),res.getInt("id_commande"),
					res.getDate("date_valide"),res.getFloat("somme_argent"),
					res.getString("address"), res.getInt("somme_jeux")						
			);
		}
		
		res.close();
		ConnexionBDD.getInstance().closeCnx();			
	} catch (SQLException e) {
		e.printStackTrace();
	}

	//

	return lu;
}



public static int insertCommande(Commande u) {
	int res = 0;
	
	Connection cnx=null;
	try {
		cnx = ConnexionBDD.getInstance().getCnx();
		
		//Requete
		String sql = "INSERT INTO commande(id_client,somme_argent,address, somme_jeux) " +
				"VALUES(?,?,?,?)";
		PreparedStatement ps = cnx.prepareStatement(sql);
		ps.setInt(1, u.getId_client());
		ps.setFloat(2, u.getSomme_argent());
		ps.setString(3, u.getAddress());
		ps.setInt(4, u.getSomme_jeux());
		//Execution et traitement de la r��ponse
		res = ps.executeUpdate();
		
		ConnexionBDD.getInstance().closeCnx();			
	} catch (SQLException e) {
		e.printStackTrace();
	}

	return res;

}




public static List<Commande_detail> findAllCommande_detail(int id) {
	
	List<Commande_detail> lu = new ArrayList<Commande_detail>();
	Connection cnx=null;
	try {
		cnx = ConnexionBDD.getInstance().getCnx();
		// ou Class.forName(com.mysql.jdbc.Driver.class.getName());
		
		//Requete
		String sql = "select id_commande_detail,id_jeux, nombre from commande_detail where id_commande=?;";
		PreparedStatement ps = cnx.prepareStatement(sql);
		ps.setInt(1,id);
		
		//Execution et traitement de la réponse
		ResultSet res = ps.executeQuery();
		
		while(res.next()){
			lu.add(new Commande_detail(res.getInt("id_commande_detail"),id ,res.getInt("id_jeux"),
					res.getInt("nombre")						
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

public static Commande_detail findCommande_detail(int id_commande, int id_commande_detail) {
	
	Commande_detail lu = null;
	Connection cnx=null;
	try {
		cnx = ConnexionBDD.getInstance().getCnx();
		// ou Class.forName(com.mysql.jdbc.Driver.class.getName());
		
		//Requete
		String sql = "select id_commande_detail,id_jeux, nombre from commande_detail where id_commande=? and id_commande_detail=? ;";
		PreparedStatement ps = cnx.prepareStatement(sql);
		ps.setInt(1,id_commande);
		ps.setInt(2,id_commande_detail);
		
		ResultSet res = ps.executeQuery();
		
		while(res.next()){
			lu = new Commande_detail(res.getInt("id_commande_detail"),id_commande ,res.getInt("id_jeux"),
					res.getInt("nombre")						
			);
		}
		
		res.close();
		ConnexionBDD.getInstance().closeCnx();			
	} catch (SQLException e) {
		e.printStackTrace();
	}

	//

	return lu;
}

public static int insertCommande_detail(Commande_detail u) {
	int res = 0;
	
	Connection cnx=null;
	try {
		cnx = ConnexionBDD.getInstance().getCnx();
		
		//Requete
		String sql = "INSERT INTO commande_detail (id_commande, id_jeux, nombre) " +
				"VALUES(?,?,?)";
		PreparedStatement ps = cnx.prepareStatement(sql);
		ps.setInt(1, u.getId_commande());
		ps.setInt(2, u.getId_jeux());
		ps.setInt(3, u.getNombre());
		res = ps.executeUpdate();
		
		ConnexionBDD.getInstance().closeCnx();			
	} catch (SQLException e) {
		e.printStackTrace();
	}

	return res;
}

public static int deleteCommande_detail(int id_commande, int id_commande_detail) {
	int res = 0;
	Connection cnx=null;
	try {
		cnx = ConnexionBDD.getInstance().getCnx();
		// ou Class.forName(com.umysql.jdbc.Driver.class.getName());

			
		//Requete
		String sql = "DELETE FROM commande_detail WHERE id_commande=? and id_commande_detail=?;";
		PreparedStatement ps = cnx.prepareStatement(sql);
		ps.setInt(1,id_commande);
		ps.setInt(2,id_commande_detail);

		//Execution et traitement de la r��ponse
		res = ps.executeUpdate();
		
		ConnexionBDD.getInstance().closeCnx();			
	} catch (SQLException e) {
		e.printStackTrace();
	}

	return res;
}

public static int deleteAllCommande_detail(int id_commande) {
	int res = 0;
	Connection cnx=null;
	try {
		cnx = ConnexionBDD.getInstance().getCnx();
		// ou Class.forName(com.umysql.jdbc.Driver.class.getName());

			
		//Requete
		String sql = "DELETE FROM commande_detail WHERE id_commande=?;";
		PreparedStatement ps = cnx.prepareStatement(sql);
		ps.setInt(1,id_commande);

		//Execution et traitement de la r��ponse
		res = ps.executeUpdate();
		
		ConnexionBDD.getInstance().closeCnx();			
	} catch (SQLException e) {
		e.printStackTrace();
	}

	return res;
}





public static int deleteCommande(int id_commande) {
	int res = 0;
	Connection cnx=null;
	try {
		cnx = ConnexionBDD.getInstance().getCnx();
		// ou Class.forName(com.umysql.jdbc.Driver.class.getName());

			
		//Requete
		String sql = "DELETE FROM commande WHERE id_commande=?;";
		PreparedStatement ps = cnx.prepareStatement(sql);
		ps.setInt(1,id_commande);

		//Execution et traitement de la r��ponse
		res = ps.executeUpdate();
		
		ConnexionBDD.getInstance().closeCnx();			
	} catch (SQLException e) {
		e.printStackTrace();
	}

	return res;
}


public static int findCommande_Enligne_Jeux(int id_commande) {
	int result=0;
	Connection cnx=null;
	try {
		cnx = ConnexionBDD.getInstance().getCnx();
		// ou Class.forName(com.mysql.jdbc.Driver.class.getName());
		
		//Requete
		String sql = "select count(*) as number from commande,commande_detail,jeux  where commande.id_commande=commande_detail.id_commande and commande_detail.id_jeux=jeux.id_jeux and jeux.type_livraison=?;";
		PreparedStatement ps = cnx.prepareStatement(sql);
		ps.setString(1,"enligne");
		
		ResultSet res = ps.executeQuery();
		
		while(res.next()){
			result =res.getInt("number");
		}
		
		res.close();
		ConnexionBDD.getInstance().closeCnx();			
	} catch (SQLException e) {
		e.printStackTrace();
	}

	//

	return result;
}

public static List<Command_jeux_union> findAllCommande_detail_jeux(int id) {
	
	List<Command_jeux_union> lu = new ArrayList<Command_jeux_union>();
	
	Connection cnx=null;
	try {
		cnx = ConnexionBDD.getInstance().getCnx();
		// ou Class.forName(com.mysql.jdbc.Driver.class.getName());
		
		//Requete
		String sql = "select commande_detail.id_commande,id_commande_detail,commande_detail.id_jeux,nombre,titre, photo_jeux,type_console,tarif from commande_detail,jeux,commande where commande_detail.id_jeux=jeux.id_jeux and commande.id_commande=commande_detail.id_commande and id_client=?;";
		PreparedStatement ps = cnx.prepareStatement(sql);
		ps.setInt(1,id);
		
		//Execution et traitement de la réponse
		ResultSet res = ps.executeQuery();
				
		while(res.next()){
			lu.add( new Command_jeux_union(res.getInt("id_commande_detail"),id ,res.getInt("id_jeux"),
					res.getInt("nombre"),
					res.getString("titre"),
					res.getString("photo_jeux"),
					res.getFloat("tarif")	
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


}

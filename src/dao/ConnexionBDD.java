package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public final class ConnexionBDD {

	private static volatile ConnexionBDD instance=null;
	private Connection cnx; 
	
	public ConnexionBDD() {
		try {
			
			Properties p = new Properties();
			p.load(Thread.currentThread().getContextClassLoader().
						getResourceAsStream("confBDD.properties"));
			
			
				
			// chargement du driver
//			Class.forName(p.getProperty("driver"));
//			cnx = DriverManager.getConnection(p.getProperty("url"),
					//p.getProperty("user"), p.getProperty("pwd"));
			Class.forName("com.mysql.jdbc.Driver");  
			cnx=DriverManager.getConnection("jdbc:mysql://localhost:3306/sr03","sr03_user","123456Ab!"); 			
			
		} catch (SQLException e) {
			System.out.println("--------------------------Connection Failed! Check output console");
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			System.out.println("--------------------------Connection Failed! ClassNotFoundException");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("--------------------------Connection Failed! IOException");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	
	public static synchronized ConnexionBDD getInstance() {
		/*System.out.println(instance);*/
		if(instance==null) {
			instance = new ConnexionBDD();}
		
		return instance;
	}

	public Connection getCnx() {
		return cnx;
	}

	public void closeCnx() throws SQLException{
		if(cnx!=null){
			cnx.close();
			instance=null;
		}
	}
}

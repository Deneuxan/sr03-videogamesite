package controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Client;
import dao.ClientDao;

/**
 * Servlet implementation class Connect
 */
@WebServlet("/Connect")
public class Connect extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ATT_SESSION_USER = "sessionClient";
	private static final String CHAMP_EMAIL  = "username";
    private static final String CHAMP_PASS   = "password";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Connect() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*doPost(request, response);*/
		/*String test=request.getParameter("username");*/
		String email = getValeurChamp( request, CHAMP_EMAIL );
        String motDePasse = getValeurChamp( request, CHAMP_PASS );

        Client client = new Client();
        client.setUsername( email );
        try {
			client.setPassword( motDePasse );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        HttpSession session = request.getSession();
        
        client = ClientDao.check_client(client);
        
        if ( client!= null) {
       	 
            session.setAttribute( ATT_SESSION_USER, client );

        } else {
            session.setAttribute( ATT_SESSION_USER, null );
        }

        request.getRequestDispatcher("connexion.jsp").forward(request, response);
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
	}
	
	
	 private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
	        String valeur = request.getParameter( nomChamp );
	        if ( valeur == null || valeur.trim().length() == 0 ) {
	            return null;
	        } else {
	            return valeur;
	        }
	    }
	    
    private static Date getValeurDate( HttpServletRequest request, String nomChamp ) throws ParseException {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
        	Date valeur_date =new SimpleDateFormat("yyyy-MM-dd").parse(valeur);
             return valeur_date;
        }
    }

}

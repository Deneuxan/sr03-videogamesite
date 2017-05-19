package dao;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Client;
import controllers.ConnexionForm;
import dao.ClientDao;

/**
 * Servlet implementation class Connexion
 */

@WebServlet("/connexion")
public class Connexion extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public static final String ATT_USER         = "client";
    public static final String ATT_FORM         = "form";
    public static final String ATT_SESSION_USER = "sessionClient";
    public static final String VUE              = "connexion.jsp";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* Affichage de la page de connexion */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* Préparation de l'objet formulaire */
        ConnexionForm form = new ConnexionForm();

        /* Traitement de la requête et récupération du bean en résultant */
        Client client = null;
		try {
			client = form.connecterClient( request );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        /* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();

        /**
         * Si aucune erreur de validation n'a eu lieu, alors ajout du bean
         * Utilisateur à la session, sinon suppression du bean de la session.
         */
        
        client = ClientDao.check_client(client);
        if ( form.getErreurs().isEmpty() && client!= null) {
        	 
            session.setAttribute( ATT_SESSION_USER, client );
        } else {
            session.setAttribute( ATT_SESSION_USER, null );
            form.setResultat("echec de l'inscription.");
        }

        /* Stockage du formulaire et du bean dans l'objet request */
        request.setAttribute( ATT_FORM, form );
        request.setAttribute( ATT_USER, client );

        /*this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );*/
        request.getRequestDispatcher("connexion.jsp").forward(request, response);
    }
}

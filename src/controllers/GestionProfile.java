package controllers;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Client;
import dao.ClientDao;
import dao.GestionClientBDD;

/**
 * Servlet implementation class GestionProfile
 */
@WebServlet("/GestionProfile")

public class GestionProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ATT_SESSION_USER = "sessionClient";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionProfile() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated constructor stub
        
		String action = request.getParameter("action");
		
		/* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();
        
		if (action != null) {
			if(action.equals("afficher"))
			{
				// recuperer une liste d'Client
				Client temp = (Client)session.getAttribute(ATT_SESSION_USER);
				Client clt = ClientDao.find(temp.getId_client());
				request.setAttribute("client", clt);
				request.setAttribute("adresse", GestionClientBDD.findAllAddress(clt.getId_client()));
				request.setAttribute("commande", GestionClientBDD.findAllCommande(clt.getId_client()));
			}
		}

		// rediriger vers une page
		request.getRequestDispatcher("profile.jsp")
				.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

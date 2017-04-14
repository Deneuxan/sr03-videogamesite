package controllers;


import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import beans.Client;
import dao.ClientDao;


/**
 * Servlet implementation class GestionClient
 */
@WebServlet("/GestionClient")
public class GestionClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		List<Client> lu = ClientDao.findAll();
		int id = 0;
		String action = request.getParameter("action");
		if (action != null) {
			String idCh = request.getParameter("id");
			if (idCh != null) {
				try {
					id = Integer.parseInt(idCh);
				} catch (Exception e) {

				}
			}

			if (action.equals("supprimer")) {
				ClientDao.delete(id);
			} else if (action.equals("modifier")) {
				request.setAttribute("uModif", ClientDao.find(id));
			} else if (action.equals("sort")) {
				// ordina la lista implicitamente utilizzando il metodo
				// compareTo dell'interfaccia Comparable (vedere la classe
				// Users)
				Collections.sort(lu);
			}
		}

		// recuperer une liste d'Client

		request.setAttribute("listeU", lu);

		// rediriger vers une page
		request.getRequestDispatcher("ClientList.jsp")
				.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		List<Client> listeU = ClientDao.findAll();

		String action = request.getParameter("action");

		if (action == null) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String gender = request.getParameter("gender");
			Date date_naissance = null;
			try {
				date_naissance = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date_naissance"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Client u = new Client(0, username,password,nom,prenom,gender,date_naissance);
			String idStr = request.getParameter("id_client");
			if (idStr != null && !idStr.trim().equals("")) {
				u.setId_client(Integer.parseInt(idStr));
				ClientDao.update(u);
			} else {
				ClientDao.insert(u);
			}

		}
		request.setAttribute("listeU", listeU);
		request.getRequestDispatcher("ClientList.jsp").forward(request, response);
	}

}

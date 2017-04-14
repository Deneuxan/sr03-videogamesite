package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RestrictionFilter implements Filter {
	 public static final String ACCES_PUBLIC     = "connexion.jsp";
	 public static final String ATT_SESSION_USER = "sessionUtilisateur";

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		/* Cast des objets request et response */
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        /* R¨¦cup¨¦ration de la session depuis la requ¨ºte */
        HttpSession session = request.getSession();

        /**
         * Si l'objet utilisateur n'existe pas dans la session en cours, alors
         * l'utilisateur n'est pas connect¨¦.
         */
        if ( session.getAttribute( ATT_SESSION_USER ) == null ) {
            /* Redirection vers la page publique */
            /*response.sendRedirect( request.getContextPath() + ACCES_PUBLIC );*/
            request.getRequestDispatcher("connexion.jsp").forward(request, response);
        } else {
            /* Affichage de la page restreinte */
            chain.doFilter( request, response );
        }

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}

<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Formation JEE</title>
</head>
<body>

	<%--@include file="entete.jsp"%>  
	  con questo comando l'include è statico, 
	mentre con il prossimo posso recuperare un parametro
	--%>
	
	<jsp:include page="entete.jsp">
		<jsp:param value="enrico" name="username"/>
	</jsp:include>
	
	<h1>Deconnexion session</h1>
	
</body>
</html>



 <!-- if ( session.getAttribute( ATT_SESSION_USER ) == null ) {
            /* Redirection vers la page publique */
            response.sendRedirect( request.getContextPath() + ACCES_PUBLIC );
        } else {
            /* Affichage de la page restreinte */
            this.getServletContext().getRequestDispatcher( ACCES_RESTREINT ).forward( request, response );
        } -->
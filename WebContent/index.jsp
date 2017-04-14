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
	
	<h1>Formation Java</h1>
	Nombre de visiteurs : ${applicationScope.nbUsers}


	<%-- alternative possibili per l'affichage 
 jsp:useBean id="nbUsers" class="java.lang.Integer" 
 scope="application" <a href="UseCookies">Liste cookies</a>
	<br />
	<a href="GestionAchats?action=showForm">Effectuer des achats</a>
	<br />
	<a href="blabla">Tester 404</a>
	<br />
	<a href="espaceAdmin">Tester interception</a>
 equivalente alla seguente
 <%=(Integer)getServletContext().getAttribute("nbUsers") %>
 <%=(Integer)application.getAttribute("nbUsers") %>
 
 --%>


	<br />
	
	<br />
	<a href="GestionUsers">Liste d'utilisateurs</a>
	<br />
	<a href="GestionUsersPagines?page=1">Liste d'utilisateurs avec
		pagination</a>
	<br />
	
	<br />
	<a href="GestionClient">Liste de clients</a>
	<br />
	
	<br />
	<%@include file="ppage.jsp"%>
</body>
</html>
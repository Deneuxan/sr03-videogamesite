<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="beans.Client"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Liste des Clients</title>
</head>
<body>
<h1>Users List</h1>
<h4>Trier par</h4>
Tri :
<form method="post" action="GestionClient">
	<input name="sortType" type="radio" value="1"/>nom
	<input name="sortType" type="radio" value="2"/>username
	<input type="hidden" name="action" value="sort" />
	<input type="submit" value="Trier" />
</form>

<table border="1">
<tr>
	<th>ID</th>
	<th>username</th>
	<th>Nom</th>
	<th>prenom</th>
	<th>gender</th>
	<th>date-n</th>
	<th>ACTIONS</th>

</tr>
	<%
		Object obj = request.getAttribute("listeU");
		if(obj!=null){
			List<Client> lu = (List<Client>)obj;
			for(Client u : lu){
	%>
			<tr>
				<td><%=u.getId_client()%></td>
				<td><%=u.getUsername()%></td>
				<td><%=u.getNom()%></td>
				<td><%=u.getPrenom()%></td>
				<td><%=u.getGender()%></td>
				<td><%=u.getDate_naissance()%></td>
				
				<td>
					<a href="GestionClient?action=supprimer&id=<%=u.getId_client()%>">Supprimer</a>
					<a href="GestionClient?action=modifier&id=<%=u.getId_client()%>">Modifier</a>	
				</td>
			</tr>
	<%
			}
			
			
		}
	%>
</table>

<h3>
<a href="GestionClient">Ajout</a>
/Modif</h3>

<form method="post" action="GestionClient">
		<label for="Username">Username :</label>
		<input type="text" name="username" id="username1" value="${uModif.username}"/>
		<br />
		<label for="Password">password :</label>
		<input type="text" name="password" id="password1" value="${uModif.password}"/>
		<br />
		<label for="Nom">Nom :</label>
		<input type="text" name="nom" id="nom1" value="${uModif.nom}"/>
		<br />
		<label for="Prenom">Prenom :</label>
		<input type="text" name="prenom" id="prenom1" value="${uModif.prenom}"/>
		<br />
		<label for="Gender">Gender :</label>
		<input type="text" name="gender" id="gender1" value="${uModif.gender}"/>
		<br />
		
		<label for="Date naissance">Date naissance :</label>
		<input type="Date" name="date_naissance" id="date_naissance1" value="${uModif.date_naissance}"/>
		<br />
		<input type="hidden" name="id_client" value="${uModif.id_client}"/>
		<input type="submit" value="Valider" />
	</form>
</body>
</html>
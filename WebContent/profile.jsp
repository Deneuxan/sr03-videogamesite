<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="beans.Client"%>
<%@page import="beans.Commande"%>
<%@page import="beans.Client_address"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Profil</title>
</head>
<body>

	<p><h3>Vos données personnelles</h3></p>
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
		Object obj = request.getAttribute("client");
		if(obj!=null){
			Client u = (Client)obj;
			
	%>
			<tr>
				<td><%=u.getId_client()%></td>
				<td><%=u.getUsername()%></td>
				<td><%=u.getNom()%></td>
				<td><%=u.getPrenom()%></td>
				<td><%=u.getGender()%></td>
				<td><%=u.getDate_naissance()%></td>
				
			</tr>
	<%
			}
	%>
</table>

<p><h3>Vos Adresses de livraison</h3></p>
<table border="1">
<tr>
	<th>Id_adresse</th>
	<th>recepteur</th>
	<th>adresse</th>
	<th>code postal</th>
	<th>ville</th>
	<th>pays</th>
	<th>telephone</th>

</tr>
	<%
		obj = request.getAttribute("adresse");
		if(obj!=null){
			List<Client_address> la = (List<Client_address>)obj;
			for(Client_address adr : la){
	%>
			<tr>
				<td><%=adr.getId_address()%></td>
				<td><%=adr.getRecepteur()%></td>
				<td><%=adr.getAddress()%></td>
				<td><%=adr.getCode_postal()%></td>
				<td><%=adr.getVille()%></td>
				<td><%=adr.getPays()%></td>
				<td><%=adr.getTelephone()%></td>
				
			</tr>
	<%
			}
			
			
		}
	%>
</table>

<p><h3>Vos Commandes</h3></p>
<table border="1">
<tr>
	<th>Id_Client</th>
	<th>Id_Commande</th>
	<th>Prix</th>
	<th>Id_Address</th>
</tr>
	<%
		obj = request.getAttribute("commande");
		if(obj!=null){
			List<Commande> lc = (List<Commande>)obj;
			for(Commande com : lc){
	%>
			<tr>
				<td><%=com.getId_client()%></td>
				<td><%=com.getId_commande()%></td>
				<td><%=com.getSomme_argent()%></td>
				<%-- <td><%=com.getId_address()%></td> --%>
			
			</tr>
	<%
			}
			
			
		}
	%>
</table>

</body>
</html>
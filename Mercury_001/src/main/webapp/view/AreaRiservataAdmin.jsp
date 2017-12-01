<<<<<<< HEAD
<%@page import="java.io.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="com.mercury.model.EventoPrevisto"%>
<%@ page import="com.mercury.model.Amministratore"%>
<%@ page import="com.mercury.model.Ente"%>
<%@ page import="com.mercury.model.dao.MercuryImp"%>
=======
<%@page import="com.mysql.fabric.xmlrpc.base.Array"%>
<%@page import="java.util.ArrayList"%>

<%@ page import="com.mercury.model.Evento"%>
<%@ page import="com.mercury.model.Amministratore"%>
>>>>>>> de9e5d28af0733e210058e0fad5b928eb2844973

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Area riservata Amministratore</title>
</head>
<body> 
<<<<<<< HEAD
<%MercuryImp m = new MercuryImp(); %> 
<%ArrayList<EventoPrevisto> eventiNotCheck = m.getEventiNotCheck();%>
<%//Amministratore a=(Amministratore)request.getAttribute("Admin"); %>

	
	<!--<h2>Benvenuto, ciccio<% //out.println(a.getEmailAdmin());%></h2>-->
	
	<% 
	for(int i = 0; i < eventiNotCheck.size(); i++){
		out.print("<form action='ServletAdmin' method='post'>");
		out.print(eventiNotCheck.get(i).getNomeEvento());
		out.print(eventiNotCheck.get(i).getDescEvento());
		//out.print(m.dateToString(eventiNotCheck.get(i).getDataInizio()));
		//out.print(m.dateToString(eventiNotCheck.get(i).getDataFine()));
		//request.setAttribute("evento", eventiNotCheck.get(i));
		//request.setAttribute("idEnte", eventiNotCheck.get(i).getIdEnte());
		out.print("<input type='submit' value='Accetta'><input type='submit' value='Ban'><br><input  type='hidden' name='pagina' value='AR'></form>");
	}
	%>

=======
<% ArrayList<Evento> elNotCheck = new ArrayList<Evento>(); %>
>>>>>>> de9e5d28af0733e210058e0fad5b928eb2844973

<%Amministratore a=(Amministratore)request.getAttribute("emailAmministratore"); %>
<div class="header"></div>
<div class="container">
	<h2>Benvenuto, <% out.println(a.getEmailAdmin());%></h2>
</div>
<div class="footer"></div>
</body>
</html>
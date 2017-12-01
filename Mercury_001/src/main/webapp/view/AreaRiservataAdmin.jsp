<%@page import="java.io.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="com.mercury.model.EventoPrevisto"%>
<%@ page import="com.mercury.model.Amministratore"%>
<%@ page import="com.mercury.model.Ente"%>
<%@ page import="com.mercury.model.dao.MercuryImp"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Area riservata Amministratore</title>
</head>
<body> 
<%MercuryImp m = new MercuryImp(); 
EnteImp ei = new EnteImp();%> 
<%ArrayList<EventoPrevisto> eventiNotCheck = m.getEventiNotCheck();
ArrayList<Ente> entiInAttesa = ei.getEventiInAttesa();
%>
<%//Amministratore a=(Amministratore)request.getAttribute("Admin"); %>

	
	<!--<h2>Benvenuto, ciccio<% //out.println(a.getEmailAdmin());%></h2>-->
	
	<% 
	for(int i = 0; i < eventiNotCheck.size(); i++) {
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
	
	<% 
	for(int i = 0; i < entiInAttesa.size(); i++){
		//deve stampare la lista degli enti in attesa di approvazione
		out.print("<form action='ServletAccettaEnte' method='post'>");
		out.print(entiInAttesa.get(i).getNomeEnte());
		out.print(entiInAttesa.get(i).getEmailEnte());
		out.print("<input type='submit' value='Accetta'><input type='submit' value='Ban'><br><input type='hidden' name='pagina' value='AR'></form>");
	}
	
	%>



</body>
</html>
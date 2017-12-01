<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jstl/core"%>
    
 <%@ page import="com.mercury.model.Ente"%>
<<<<<<< HEAD
  <%@ page import="com.mercury.model.dao.EnteImp"%>
  <%@ page import="com.mercury.model.EventoPrevisto"%>
=======
  <%@ page import="com.mercury.model.Evento"%>
>>>>>>> de9e5d28af0733e210058e0fad5b928eb2844973
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="Style.css" rel="stylesheet" type="text/css">
<title>Area Riservata Ente</title>
</head>
<body>
<<<<<<< HEAD
<% ArrayList<EventoPrevisto> myEvents = getEventiByEnte();%>
=======
<% ArrayList<Evento> myEvents = getEventiByEnte();%>
>>>>>>> de9e5d28af0733e210058e0fad5b928eb2844973
<%Ente e=(Ente)request.getAttribute("nomeEnte"); %>
<div class="header"></div>
<div class="container">
	<h2>Benvenuto,<% out.println(e.getNomeEnte());%></h2>
	
		<c:out value="${item.getNomeEnte()}" /><br>
		<c:out value="${item.getEmailEnte()}" />
	
<<<<<<< HEAD
	<%
		for(int i = 0; i < myEvents.size(); i++) {
			out.print("<form action='ServletEnte' method='post'>");
			out.print(myEvents.get(i).getNomeEvento);
			out.print();
			out.print("<input type='submit' value='Modifica Evento'></form>");
			
		}
	
	
	%>
=======

	<div class="ricerca">
	<c:forEach items="${myEvents}" var="item">
		<form action="ServletEnte" method="post">
			<c:out value="${item.getNomeEvento()}" /><br>
			<c:out value="${item.getDescEvento()}" /><br>
			<c:out value="${item.getDataInizio()}" /><br>
			<c:out value="${item.getDataFine()}" /><br><br>
			<input type="submit" value="Modifica Evento">
		</form>	
	</c:forEach>
	</div>
>>>>>>> de9e5d28af0733e210058e0fad5b928eb2844973

	<form action="ServletEnte" method="post">
		<input type="submit" value="Inserisci nuovo evento">
	</form>
<<<<<<< HEAD


=======
</div>
<div class="footer"></div>
>>>>>>> de9e5d28af0733e210058e0fad5b928eb2844973


</body>
</html>
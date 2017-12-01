<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jstl/core"%>
    
 <%@ page import="com.mercury.model.Ente"%>
  <%@ page import="com.mercury.model.dao.EnteImp"%>
  <%@ page import="com.mercury.model.EventoPrevisto"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="Style.css" rel="stylesheet" type="text/css">
<title>Area Riservata Ente</title>
</head>
<body>
<% ArrayList<EventoPrevisto> myEvents = getEventiByEnte();%>
<%Ente e=(Ente)request.getAttribute("nomeEnte"); %>
<div class="header"></div>
<div class="container">
	<h2>Benvenuto,<% out.println(e.getNomeEnte());%></h2>
	
		<c:out value="${item.getNomeEnte()}" /><br>
		<c:out value="${item.getEmailEnte()}" />
	
	<%
		for(int i = 0; i < myEvents.size(); i++) {
			out.print("<form action='ServletEnte' method='post'>");
			out.print(myEvents.get(i).getNomeEvento);
			out.print();
			out.print("<input type='submit' value='Modifica Evento'></form>");
			
		}
	
	
	%>

	<form action="ServletEnte" method="post">
		<input type="submit" value="Inserisci nuovo evento">
	</form>




</body>
</html>
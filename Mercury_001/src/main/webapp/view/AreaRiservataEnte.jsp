<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jstl/core"%>
    
 <%@ page import="com.mercury.model.Ente"%>
  <%@ page import="com.mercury.model.Evento"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="Style.css" rel="stylesheet" type="text/css">
<title>Area Riservata Ente</title>
</head>
<body>
<% ArrayList<Evento> myEvents = new ArrayList<Evento>(); %>
<%Ente e=(Ente)request.getAttribute("nomeEnte"); %>
<div class="header"></div>
<div class="container">
	<h2>Benvenuto,<% out.println(e.getNomeEnte());%></h2>
	
		<c:out value="${item.getNomeEnte()}" /><br>
		<c:out value="${item.getEmailEnte()}" />
	

	<div class="ricerca">
	<c:forEach items="${myEvents}" var="item">
		<form action="ServletEnte" method="post">
			<c:out value="${item.getEventiByEnte()}" /><br><br>
			<input type="submit" value="Modifica Evento">
		</form>	
	</c:forEach>
	</div>

	<form action="ServletEnte" method="post">
		<input type="submit" value="Inserisci nuovo evento">
	</form>






</div>
<div class="footer"></div>


</body>
</html>
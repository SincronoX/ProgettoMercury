<%@page import="com.mysql.fabric.xmlrpc.base.Array"%>
<%@page import="java.util.ArrayList"%>

<%@ page import="com.mercury.model.Evento"%>
<%@ page import="com.mercury.model.Amministratore"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Area riservata Amministratore</title>
</head>
<body> 
<% ArrayList<Evento> elNotCheck = new ArrayList<Evento>(); %>

<%Amministratore a=(Amministratore)request.getAttribute("emailAmministratore"); %>
<div class="header"></div>
<div class="container">
	<h2>Benvenuto, <% out.println(a.getEmailAdmin());%></h2>
</div>
<div class="footer"></div>
</body>
</html>
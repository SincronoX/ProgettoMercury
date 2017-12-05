<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList"%>
    <%@ page import="com.mercury.model.dao.TipoEventoImp"%>
    <%@ page import="com.mercury.model.TipoEvento"%>
    <%@ page import="com.mercury.model.Ente"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*"%>
<sql:query var="rs" dataSource="jdbc/mercury">
SELECT idRegione, nomeRegione from mercury.regione 
</sql:query>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserisci un nuovo evento</title>
<script language ="JavaScript" type="text/javascript" src="../js/controlloDate.js"></script>
<script src="http://code.jquery.com/jquery-1.11.1.js" type="text/javascript"></script>
<script language="JavaScript" type="text/javascript" src="../js/newsletter.js"></script>
</head>
<body>
<%TipoEventoImp ei = new TipoEventoImp();
ArrayList<TipoEvento> catEvento =  ei.getEventoCatAll();
Ente e = (Ente)request.getAttribute("ente");

out.print("Benvenuto, " + e.getNomeEnte());

%>
<form action='../ServletEnte' method='post' onSubmit='return controllo(this);'>
<input type="submit" name="nuovoEvento" value="Inserisci"><br><br>

<input type='text' name='nomeEvento'><br><br>
<input type='text' name='descEvento'><br><br>
<input type='date' name='dataInizio'><br><br>
<input type='date' name='dataFine'><br><br>
<select name='tipoEvento'>
	<option selected="selected" value='opt'></option>
	<%for(int i = 0; i< catEvento.size(); i++){
		out.print("<option value='"+catEvento.get(i).getIdTipoEvento()+"'>"+catEvento.get(i).getCatEvento()+"</option>");
	}%>
</select>
<<<<<<< HEAD

<p class="testoGenerale">
Seleziona regione: <select id="regioni"  name="regioni"  >
<option  label="Selezionare" selected="selected"/>
	<c:forEach var="r" items="${rs.rows }">
		<option value=<c:out value="${r.idRegione}" /> />
		<c:out value="${r.nomeRegione}" />
	</c:forEach>
</select>
</p>

<%//out.print("<input type='hidden' name='idEnte' value='"+ e.getIdEnte() +"'>"); %>
<input type="reset" value="Annulla">
=======
<%out.print("<input type='hidden' name='idEnte' value='"+ e.getIdEnte() +"'>"); %>
>>>>>>> 25fa4aa7a12405cd6ffe92d518cc1cd4685ac4d1
</form>
</body>
</html>
   
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*" %>
<sql:query var="rs" dataSource="jdbc/mercury" >
SELECT idEnte, nomeEnte from mercury.ente 
</sql:query>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <div class="text content-subitem">
		<p>Iscriviti ora alla newsletter gratuita di SincronoX e riceverai
			in anticipo informazioni su: nuovi eventi e ecc...</p>

	
		<p>E' semplicissimo, iscriviti con il tuo indirizzo e-mail.</p>
		</div>

<h2>Scegli la tua preferenza in base a:</h2>		
<form ACTION="">
<table>
<td> 
<p>Seleziona regione:
<select name="regioni" onchange="">
<c:forEach var="r" items="${rs.rows }">
<option value="${r.idEnte}"/><c:out value="${r.nomeEnte}"/>
</c:forEach>
</select>
</p>
</td> 

<td>
<p>Seleziona provincia:
<select name="regioni" onchange="">
<c:forEach var="r" items="${rs.rows }">
<option value="${r.idEnte}"/><c:out value="${r.nomeEnte}"/>
</c:forEach>
</select>
</p>
</td> 

<td>
<p>Seleziona comune:
<select name="regioni" onchange="">
<c:forEach var="r" items="${rs.rows }">
<option value="${r.idEnte}"/><c:out value="${r.nomeEnte}"/>
</c:forEach>
</select>
</p>
</td>
</table>



	<h2>Scegli la tua preferenza di ricezione dell'e-mail :</h2>
	<input type="checkbox" name="id" value="Giornaliera">Giornaliera<BR>
	<input type="checkbox" name="id" value="Settimanale">Settimanale<BR>
	<input type="checkbox" name="id" value="Mensile">Mensile<BR>
	<BR> <input type="submit" value="Submit"></br></br>

       
         Inserisci il tuo indirizzo email: <input type = "text" name = "last_name" />
         <input type = "submit" value = "Submit" />
      </form>

</body>
</html>


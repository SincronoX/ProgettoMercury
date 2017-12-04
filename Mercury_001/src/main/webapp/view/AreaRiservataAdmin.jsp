<%@page import="java.io.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="com.mercury.model.EventoPrevisto"%>
<%@ page import="com.mercury.model.Amministratore"%>
<%@ page import="com.mercury.model.Ente"%>
<%@ page import="com.mercury.model.dao.EnteImp"%>
<%@ page import="com.mercury.model.dao.MercuryImp"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="..//css/Style.css">
<title>Area riservata Amministratore</title>
</head>
<body> 
<div class="container"> <!--INIZIO CLASSE CONTAINER-->
<div class="row"><!--INIZIO CLASSE ROW-->

		
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <img class="fotoMercury" src="mercury.png">
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Home <span class="sr-only">(current)</span></a></li>
        <li><a href="#">Newsletter</a></li>
        <li><a href="#">Eventi</a></li>
        <li><a href="#">Chi Siamo</a></li>
        <li><a href="#">Area Riservata</a></li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>



<%MercuryImp m = new MercuryImp(); 
EnteImp ei = new EnteImp();%> 
<%ArrayList<EventoPrevisto> eventiNotCheck = m.getEventiNotCheck();

ArrayList<Ente> entiInAttesa = ei.getEntiInAttesa();

%>    
<%Amministratore a=(Amministratore)request.getAttribute("Admin"); %>

	<h2>Benvenuto, <% //out.println(a.getEmailAdmin());%></h2>

	
<div id="eventiHome" class="col-md-8">
	<h2>Eventi da approvare</h2>
	
	
	<%
	for(int i = 0; i < eventiNotCheck.size(); i++) {
		out.print("<p>");
		out.print("<form action='../ServletRicerca' method='post'>");
		out.print(eventiNotCheck.get(i).getNomeEvento());
		out.print(eventiNotCheck.get(i).getDescEvento());
		out.print(m.dateToString(eventiNotCheck.get(i).getDataInizio()));
		out.print(m.dateToString(eventiNotCheck.get(i).getDataFine()));
		session.setAttribute("evento" + i, eventiNotCheck.get(i));
		session.setAttribute("check", eventiNotCheck.get(i).isCheck());
		out.print("<br><input type='submit' value='Accetta' name ='checkOK'><input type='submit' value='Ban' name='checkOK'><br><input  type='hidden' name='pagina' value='AR'><input  type='hidden' name='numEv' value='"+i+"'></form>");

		out.print("</p>");
	}
	
	%>
	<%
	for(int i = 0; i < entiInAttesa.size(); i++) {
		//deve stampare la lista degli enti in attesa di approvazione
		out.print("<p>");
		out.print("<form action='../ServletRicerca' method='post'>");
		out.print(entiInAttesa.get(i).getNomeEnte());
		out.print(entiInAttesa.get(i).getEmailEnte());
		session.setAttribute("enteInAttesa" + i, entiInAttesa.get(i));
		out.print("<input type='submit' value='Accetta' name='enteOK'><input type='submit' value='Rifiuta' name='enteOK'><br><input type='hidden' name='eia' value='AR'><input  type='hidden' name='pagina' value='AR'><input  type='hidden' name='entInAtt' value='"+i+"'></form>");
		out.print("</p>");
	}%>
</div>
</body>
 <!--INIZO SCRIPT BOOTSTRAP -->
 	<script type="text/javascript" src="..//js/app.js"></script>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<!--FINE SCRIPT BOOTSTRAP -->	
   

</html>
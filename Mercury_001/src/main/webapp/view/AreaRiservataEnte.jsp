<%@ page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jstl/core"%>
  <%@ page import="com.mercury.model.dao.MercuryImp"%>  
 <%@ page import="com.mercury.model.Ente"%>
  <%@ page import="com.mercury.model.dao.EnteImp"%>
  <%@ page import="com.mercury.model.EventoPrevisto"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="..//css/Style.css">
<title>Area Riservata Ente</title>
</head>
<body>

<div id="sfondo"></div> 

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


<div id="eventiHome" class="col-md-6" >
<% 
MercuryImp m = new MercuryImp();
ArrayList<EventoPrevisto> myEvents = new ArrayList<EventoPrevisto>();
//EnteImp ei=(EnteImp)request.getAttribute("ente"); 
//Ente e = (Ente)request.getAttribute("ente"); 
//String mailEnte = e.getEmailEnte();
EnteImp ei = new EnteImp();
myEvents = ei.getEventiByEnte("rockinroma@roma.it");
%>
</div>

	<h2>Benvenuto,<% //out.println(e.getNomeEnte());%></h2>

	
	<div id="eventiHome" class="col-md-6">
	<%
	for(int i = 0; i < myEvents.size(); i++) { //lista degli eventi dell'ente
	out.print("<form action='../ServletEnte' method='post'>");	
	out.print(myEvents.get(i).getNomeEvento());
	out.print(myEvents.get(i).getDescEvento());
	out.print(m.dateToString(myEvents.get(i).getDataInizio()));
	out.print(m.dateToString(myEvents.get(i).getDataFine()));
	session.setAttribute("eventi" + i, myEvents.get(i));
	out.print("<input type='submit' value='Modifica' name='modEv'><input type='submit' value='Elimina' name='modEv'><input  type='hidden' name='numEv' value='"+i+"'>");
	out.print("</form>");
	}
	%>
	</div>
	
	<form action="../ServletEnte" method="post">
	<input type="submit" value="Inserisci nuovo Evento">
	</form>

</div>
</body>

<!-- APERTURA FOOTER-->
<footer class="footer">
    	<dd> Creato da: Gruppo SINCRONO - <time datetime="2010-11-23" pubdate>Lunedi 4 Dicembre</time></dd>
		<small>Tutti i contenuti sono prottetti dalla licenza creative commons</small>
</footer>
<!-- CHIUSURA FOOTER-->


 <!--INIZO SCRIPT BOOTSTRAP -->
 	<script type="text/javascript" src="..//js/app.js"></script>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<!--FINE SCRIPT BOOTSTRAP -->	
</html>
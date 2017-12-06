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
<link rel="stylesheet" type="text/css" href="css/Style.css">
<title>Area Riservata Ente</title>
</head>
<body> 

<div id="sfondo"></div> 

<div class="container"> <!--INIZIO CLASSE CONTAINER-->
<div class="row"><!--INIZIO CLASSE ROW-->

		
<!-- INIZIO NAVBAR -->				
	 <nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	    <!-- Brand and toggle get grouped for better mobile display -->
	    <div class="navbar-header">
	      <img id="fotoMercury" src="../img/nuovoLogo1.png">
	    </div>

	    <!-- Collect the nav links, forms, and other content for toggling -->
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      <ul class="nav navbar-nav" id="navbar">
	        <li class="active"><a onclick="location.href='HomePage.jsp'">Home <span class="sr-only">(current)</span></a></li>
	        <li><a onclick="location.href='Newsletter.jsp'">Newsletter</a></li>
	        <li><a  onclick="location.href='RisultatoRicerca.jsp'" >Eventi</a></li>
	        <li><a onclick="location.href='LoginEnte.jsp'" href="#">Area Riservata</a></li>
	      </ul>
	    </div><!-- /.navbar-collapse -->
	  </div><!-- /.container-fluid -->
	</nav>
	<!-- FINE NAVBAR -->	

	<% 
		MercuryImp m = new MercuryImp(); 
		ArrayList<EventoPrevisto> myEvents = new ArrayList<EventoPrevisto>();
		Ente e = (Ente)request.getAttribute("ente"); 
		String mailEnte = e.getEmailEnte();
		EnteImp ei = new EnteImp();
		myEvents = ei.getEventiByEnte(mailEnte);
	%>	
	


	<h2 class="testoGenerale">Benvenuto,<% out.println(" "+e.getNomeEnte());%></h2>
	
	<form action="../ServletLogEnte" method="post">
	<input type="submit" value="Logout" name="log" class="btn btn-danger" >
	</form>
	<hr>
	<br>
	<div id="eventiHome" class="col-md-12">
	<%
	for(int i = 0; i < myEvents.size(); i++) { //lista degli eventi dell'ente
	out.print("<form id='formEnte'  class='panel panel-info' action='ServletEnte' method='post'>");	
	out.print(myEvents.get(i).getNomeEvento());
	out.print("<br>");
	out.print(myEvents.get(i).getDescEvento());
	out.print("<br>");
	out.print("Data inizio: ");
	out.print(m.dateToString(myEvents.get(i).getDataInizio()));
	out.print("<br>");
	out.print("Data fine: ");
	out.print(m.dateToString(myEvents.get(i).getDataFine()));
	session.setAttribute("eventi" + i, myEvents.get(i));
	out.print("<input type='submit' value='Modifica' name='modEv' id='butEnte' class='btn btn-primary' ><input type='submit' value='Elimina' name='modEv' id='butEnte' class='btn btn-danger' ><input  type='hidden' name='numEv' value='"+i+"'>");
	out.print("</form>");
	}
	%>
	</div>
	<div class= col-md-10></div>
	<form action="ServletEnte" method="post">
	<input type="hidden" value="<% out.print(e.getEmailEnte()); %>" name="email">
	<input type="submit" value="Aggiungi" name="modEv" class="btn btn-success">
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
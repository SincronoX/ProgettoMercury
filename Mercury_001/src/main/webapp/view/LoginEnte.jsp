<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LOGIN ENTE</title>
<!--COLLEGAMENTO AL CSS BOOTSTRAP-->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="..//css/Style.css">
<!-- Fine collegamento css bootstrap -->
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

<div class="form1">
	<form class=loginform action="ServletLogEnte.java">
		<input class=input type="text" placeholder="Email" name="emailEnte" required>
		<input class=input type="password" placeholder="Password" name="pswEnte" required>
		<button class=loginbtn type="submit" value="login" name="log">Login</button>
	</form>
	<form class=registraform action="RegistrazioneEnte.jsp">
		<input class=registrabtn type="submit" value="Registrati"/>
	</form>
</div>
</div>
</div>
</body>
<!-- APERTURA FOOTER-->
<footer class="footer">
    	<dd> Creato da: Gruppo SINCRONO - <time datetime="2010-11-23" pubdate>Lunedi 4 Dicembre</time></dd>
 		<small>Tutti i contenuti sono prottetti dalla licenza creative commons</small>
</footer>
<!-- CHIUSURA FOOTER-->

<!--INIZO SCRIPT BOOTSTRAP -->
	<script type="text/javascript" src="../js/app.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<!--FINE SCRIPT BOOTSTRAP -->	
</html>
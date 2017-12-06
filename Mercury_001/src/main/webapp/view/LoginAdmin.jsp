
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.mercury.model.Amministratore"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LOGIN ADMIN</title>
<!--COLLEGAMENTO AL CSS BOOTSTRAP-->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="..//css/Style.css">
<!-- Fine collegamento css bootstrap -->
</head>
<body>

	<form class=loginform action="../ServletLogAdmin" method="post">
	
	<%Amministratore a=(Amministratore)request.getAttribute("Admin"); %>

		<div id="sfondo"></div>

		<div class="container">
			<!--INIZIO CLASSE CONTAINER-->
			<div class="row">
				<!--INIZIO CLASSE ROW-->

				<nav class="navbar navbar-inverse">
				<div class="container-fluid">
					<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header">
						<img id="fotoMercury" src="../img/nuovoLogo1.png">
					</div>

					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav">
							<li class="active"><a href="#">Home <span
									class="sr-only">(current)</span></a></li>
							<li><a href="#">Newsletter</a></li>
							<li><a href="#">Eventi</a></li>
							<li><a href="#">Chi Siamo</a></li>
							<li><a href="#">Area Riservata</a></li>
						</ul>
					</div>
					<!-- /.navbar-collapse -->
				</div>
				<!-- /.container-fluid --> </nav>
				<div class="form3">
					<form class="loginform" action="ServletLogAdmin">
			<input class="input" type="text" placeholder="Username"	name="emailAdmin" required> 
			<input class="input" type="password" placeholder="Password" name="pswAdmin" required>
						<button class="loginbtn" type="submit">Login</button>
						<input type="hidden" name="form" value="LoginAdmin">
					</form>
				</div>
</body>

<!-- APERTURA FOOTER-->
<footer class="footer">

<dd>
	Creato da: Gruppo SINCRONO -
	<time datetime="2010-11-23" pubdate>Lunedi 4 Dicembre</time>
</dd>
<small>Tutti i contenuti sono prottetti dalla licenza creative
	commons</small> </footer>


<!--INIZO SCRIPT BOOTSTRAP -->
<script type="text/javascript" src="../js/app.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
<!--FINE SCRIPT BOOTSTRAP -->
</html>



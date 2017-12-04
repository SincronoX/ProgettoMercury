
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*"%>
<sql:query var="rs" dataSource="jdbc/mercury">
SELECT idRegione, nomeRegione from mercury.regione 
</sql:query>
<sql:query var="tipo" dataSource="jdbc/mercury">
SELECT idTipoEvento, catEvento from mercury.tipoevento
</sql:query>
<html>
<head>
<!--COLLEGAMENTO AL CSS BOOTSTRAP-->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="..//css/Style.css">
<!-- Fine collegamento css bootstrap -->


<script src="http://code.jquery.com/jquery-1.11.1.js"
	type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#regioni").change(
				function(event) {
					var regione = $("select#regioni").val();
					$.get("../ServletLuogo", {
						idRegione : regione
					}, function(response) {
						var select = $("#province");
						select.find("option").remove();
						$.each(response, function(index, obj) {
							$("<option>").val(obj.idProvincia).text(obj.nomeProvincia).appendTo(select);
						});
						$("<option>").text("Selezionare").prependTo(select).attr("selected","selected");
						$("#comuni").find("option").remove();
					});
				});
	});
</script>

<script type="text/javascript">
	$(document).ready(function() {
		$("#province").change(
				function(event) {
					var provincia = $("select#province").val();
					$.get("../ServletLuogo", {
						idProvincia : provincia
					}, function(response) {
						var select = $("#comuni");
						select.find("option").remove();
						$.each(response, function(index, obj) {
							$("<option>").val(obj.idComune).text(obj.nomeComune).appendTo(select);
						});
						$("<option>").text("Selezionare").prependTo(select).attr("selected","selected");
					});
				});
	});
</script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>NewsLetter</title>
</head>
<body>
<div id="sfondo"></div> 
<div class="container"> <!--INIZIO CLASSE CONTAINER-->
	<div class="row"><!--INIZIO CLASSE ROW-->
					
	  <nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	  
	    <!-- Brand and toggle get grouped for better mobile display -->
	    <div class="navbar-header">
	      <img id="fotoMercury" src="../img/nuovoLogo1.png">
	    </div>

	    <!-- Collect the nav links, forms, and other content for toggling -->
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      <ul class="nav navbar-nav">
	        <li class="active"><a id="home">Home <span class="sr-only">(current)</span></a></li>
	        <li><a id="navbar">Newsletter</a></li>
	        <li><a id="navbar">Eventi</a></li>
	        <li><a id="navbar">Chi Siamo</a></li>
	        <li><a id="navbar">Area Riservata</a></li>
	        
	      </ul>
	    </div><!-- /.navbar-collapse -->
	  </div><!-- /.container-fluid -->
	</nav>


	<div class="text content-subitem">
		<p class="testoGenerale">Iscriviti ora alla newsletter gratuita di SincronoX e riceverai
			in anticipo informazioni su: nuovi eventi e ecc...
			</p>
		
</div>


		<p class="testoGenerale">E' semplicissimo, iscriviti con il tuo indirizzo e-mail.</p>
	</div>

	<h2 class="testoGenerale">Scegli la tua preferenza in base a:</h2>
	<form ACTION="../ServletMail" method="post">
		<table>
			<td>
				<p class="testoGenerale">
					Seleziona regione: <select id="regioni"  name="regioni"  >
					<option  label="Selezionare" selected="selected"/>
						<c:forEach var="r" items="${rs.rows }">
							<option value=<c:out value="${r.idRegione}" /> />
							<c:out value="${r.nomeRegione}" />
						</c:forEach>
					</select>
				</p>
			</td>

			<td>
				<p class="testoGenerale">
					Seleziona provincia: <select id="province" name="province" >
						
					</select>
				</p>
			</td>

			<td>
				<p class="testoGenerale">
					Seleziona comune: <select id="comuni" name="idComune" >
						
					</select>
				</p>
			</td>
		</table>



		<h2 class="testoGenerale">Scegli la tua preferenza di ricezione dell'e-mail :</h2>
		<input type="radio" name="idCadenza" value="1">Giornaliera<BR>
		<input type="radio" name="idCadenza" value="2">Settimanale<BR>
		<input type="radio" name="idCadenza" value="3">Mensile<BR>
		<BR> <br> <br> Inserisci il
		tuo indirizzo email: <input type="text" name="emailUtente" /> <br>
		<p>
		Scegli le tue preferenze
		<br>
		<input type="checkbox" name="idPreferenza1" value="1">Concerto<BR>
		<input type="checkbox" name="idPreferenza2" value="2">Film<BR>
		<input type="checkbox" name="idPreferenza3" value="3">Teatro<BR>
		<input type="checkbox" name="idPreferenza4" value="4">Mostra<BR>
		<input type="checkbox" name="idPreferenza5" value="5">Altro<BR>
		</p>
		<br>
		<input type="hidden" value="newsletter"/>
		<input
			type="submit" value="Submit" class="btn btn-success" />
	</form>
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



<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*"%>
<sql:query var="rs" dataSource="jdbc/mercury">
SELECT idRegione, nomeRegione from mercury.regione 
</sql:query>
<html>
<head>
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
	<div class="text content-subitem">
		<p>Iscriviti ora alla newsletter gratuita di SincronoX e riceverai
			in anticipo informazioni su: nuovi eventi e ecc...</p>


		<p>E' semplicissimo, iscriviti con il tuo indirizzo e-mail.</p>
	</div>

	<h2>Scegli la tua preferenza in base a:</h2>
	<form ACTION="" method="get">
		<table>
			<td>
				<p>
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
				<p>
					Seleziona provincia: <select id="province" name="province" >
						
					</select>
				</p>
			</td>

			<td>
				<p>
					Seleziona comune: <select id="comuni" name="comuni" >
						
					</select>
				</p>
			</td>
		</table>



		<h2>Scegli la tua preferenza di ricezione dell'e-mail :</h2>
		<input type="checkbox" name="id" value="Giornaliera">Giornaliera<BR>
		<input type="checkbox" name="id" value="Settimanale">Settimanale<BR>
		<input type="checkbox" name="id" value="Mensile">Mensile<BR>
		<BR> <input type="submit" value="Submit"></br> </br> Inserisci il
		tuo indirizzo email: <input type="text" name="last_name" /> <input
			type="submit" value="Submit" />
	</form>
</body>
</html>


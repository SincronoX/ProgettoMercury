<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserisci un nuovo evento</title>
</head>
<body>
<form action='../ServletEnte' method='post'>
<input type='text' name='nomeEvento'>
<input type='text' name='descEvento'>
<input type='date' name='dataInizio'>
<input type='date' name='dataFine'>
<select name='tipoEvento'>
	<option>cacca</option>
	<option>pipi</option>

</select>
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList"%>
    <%@ page import="com.mercury.model.dao.TipoEventoImp"%>
    <%@ page import="com.mercury.model.TipoEvento"%>
    <%@ page import="com.mercury.model.Ente"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<<<<<<< HEAD

<%@ page import="java.sql.*"%>
<sql:query var="rs" dataSource="jdbc/mercury">
	SELECT idRegione, nomeRegione from mercury.regione 
</sql:query>

=======
>>>>>>> 14ea08966074920330779020ac1e3e74a4fbe913
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserisci un nuovo evento</title>
<<<<<<< HEAD
<script src="http://code.jquery.com/jquery-1.11.1.js" type="text/javascript"></script>
<script type="text/javascript" src="./js/controlloDate.js"></script>
<script type="text/javascript" src="./js/newsletter.js"></script>
=======
<script type="text/javascript">
function giorniNelMese(mese) {
	if(mese==0 || mese==2 || mese==4 || mese==6 || mese==7 || mese==9 || mese==11)
		return 31;
	else if(mese==1)
		return 28;
	else
		return 30;
}

function controllo(form) {
	var today = new Date();
	var nGio = giorniNelMese(today.getMonth());
	var a = (today.getDate()+7) % nGio;
	
	 var dataIn = new Date(form.dataInizio.value);
	 var dataFin = new Date(form.dataFine.value);
	if((a >= dataIn.getDate() && today.getMonth() >= dataIn.getMonth()) && today.getYear() >= dataIn.getYear()){
		alert("Errore.");
		return false;
	}
	else if(dataIn.getMonth() < today.getMonth() && dataIn.getYear() < today.getYear()) {
		alert("Errore.");
		return false;
	}
	else if(dataIn.getYear() < today.getYear()) {
		alert("Errore.");
		return false;
	}
	
	if(dataFin < dataIn) {
		alert("Inserire una data di fine valida");
		return false;
	}
	
	 if(form.nomeEvento.value == "") {
	      alert("Inserire un nome per l'evento");
	      return false;
	}
	 else  if(form.descEvento.value == "") {
	      alert("Inserire una descrizione");
	      return false;
	}
	 else if(form.tipoEvento.value == "opt") {
	      alert("Inserire una categoria per l'evento");
	      return false;
	}
	 
	 return false;
	 
	
}

</script>
>>>>>>> 14ea08966074920330779020ac1e3e74a4fbe913
</head>
<body>
<%TipoEventoImp ei = new TipoEventoImp();
ArrayList<TipoEvento> catEvento =  ei.getEventoCatAll();
Ente e = (Ente)request.getAttribute("ente");

out.print("Benvenuto, " + e.getNomeEnte());
out.print("<br><br>");

%>
<form action="ServletEnte" method="post" >
<!-- onSubmit='return controlloBello(this);'> -->


Nome Evento: <input type='text' name='nomeEvento'><br><br>
Descrizione: <input type='text' name='descEvento'><br><br>
Data di inizio: <input type='date' name='dataInizio'><br><br>
Data di fine: <input type='date' name='dataFine'><br><br>
Selezionare il tipo di evento:
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
<p class="testoGenerale">
	Seleziona provincia: <select id="province" name="province" ></select>
</p>
<p class="testoGenerale">
	Seleziona comune: <select id="comuni" name="idComune" ></select>
</p>
<input type="reset" value="Annulla">
<input type="submit" name="modEv" value="Inserisci"><br><br>
<input type="hidden" name="erica" value="<% out.print(e.getEmailEnte()); %>">
=======
<%out.print("<input type='hidden' name='idEnte' value='"+ e.getIdEnte() +"'>"); %>
>>>>>>> 14ea08966074920330779020ac1e3e74a4fbe913
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="java.util.ArrayList"%>
 <%@ page import="com.mercury.model.EventoPrevisto"%>
 <%@ page import="com.mercury.model.dao.MercuryImp"%>   
  <%@ page import="com.mercury.model.dao.TipoEventoImp"%> 
  <%@ page import="com.mercury.model.TipoEvento"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modifica Evento</title>

<!-- devo prendere in input un intero evento-->
<!-- devo restituire l'evento modificato -->

<% MercuryImp m = new MercuryImp();
TipoEventoImp TipoEv = new TipoEventoImp();
EventoPrevisto evPrev = (EventoPrevisto)request.getAttribute("evPrev");
String nomeEvento = evPrev.getNomeEvento();
String descEvento = evPrev.getDescEvento();
String dInizio = m.dateToString(evPrev.getDataInizio());
String dFine = m.dateToString(evPrev.getDataFine());
int idTipoEv = evPrev.getIdTipoEvento();
TipoEvento tipoEv = TipoEv.getTipoEventoById(idTipoEv);
ArrayList<TipoEvento> catEvento =  TipoEv.getEventoCatAll();

%>

</head>
<body>
<form action="ServletEnte" method="post">
Nome: <input type='text' name='nomeEvento' value = '"+<%out.print(nomeEvento); %>+"'>
Descrizione : <input type='text' name='descEvento' value = '"+<%out.print(descEvento); %>+"'>
Data di inizio: <input type='text' name='dInizio' value = '"+<%out.print(dInizio); %>+"'>
Data di fine: <input type='text' name='dFine' value = '"+<%out.print(dFine); %>+"'>
Tipo Evento:
<select name='tipoEvento'>
	<option selected="selected" value='"+<%out.print(tipoEv.getCatEvento()); %>+"'></option>
	<%for(int i = 0; i< catEvento.size(); i++){
		out.print("<option value='"+catEvento.get(i).getIdTipoEvento()+"'>"+catEvento.get(i).getCatEvento()+"</option>");
	}%>
</select>


Seleziona regione: <select id="regioni"  name="regioni"  >
<option  label="Selezionare" selected="selected"/>
	<c:forEach var="r" items="${rs.rows }">
		<option value=<c:out value="${r.idRegione}" /> />
		<c:out value="${r.nomeRegione}" />
	</c:forEach>
</select>

Seleziona provincia: <select id="province" name="province" ></select>

Seleziona comune: <select id="comuni" name="idComune" ></select>
<%session.setAttribute("eventoMod", evPrev); %>
<input type="submit" name="modEv" value="Invia">
<input type="submit" name="modEv" value="Annulla">
</form>
</body>
</html>
// Fabio Savelli

package com.mercury.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.mercury.model.EventoPrevisto;

public class EventoPrevistoImp implements EventoPrevistoUtil {

	Connection conn=null;
	
	public Calendar stringToDate(String s) {
		String[] aux = s.split(" - ");
		int anno = Integer.parseInt(aux[0]);
		int mese = Integer.parseInt(aux[1]) - 1; 
		int giorno = Integer.parseInt(aux[2]);
		Calendar ret = new GregorianCalendar(anno, mese, giorno);
		return ret;
	}
	public String dateToString(Calendar c) {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy - MM - dd");
		String ret = format1.format(c.getTime());
		return ret;
	}

	
	public String toString(String nomeEvento, int idEvento) {
		// TODO Auto-generated method stub
		return "L'evento: "+nomeEvento+" ha id: "+idEvento;
	}

	public EventoPrevisto getEventoPrevistoById(int id) throws SQLException {
		// TODO Auto-generated method stub
		if(conn==null) conn=DAO.getConnection();
        Statement st = conn.createStatement();
        
        ResultSet rs = st.executeQuery("SELECT * FROM mercury.eventoprevisto where idEvento = '"+id+"';");
        
        EventoPrevisto nuovo = new EventoPrevisto();
        
        try {
        	rs.first();
       		
       		int idTipoEvento =     rs.getInt("idTipoEvento");
       		int idEvento =         rs.getInt("idEvento");
       		int idEnte =		   rs.getInt("idEnte");
       		String idComune =      rs.getString("idComune");
       		String nomeEvento =    rs.getString("nomeEvento");
       		String descEvento =    rs.getString("descEvento");
       		String dataInizioAUX = rs.getString("dataInizio"); 
       		String dataFineAUX =   rs.getString("dataFine");
       		boolean checked = 	   rs.getBoolean("checked");
       		Calendar dataInizio = stringToDate(dataInizioAUX);
       		Calendar dataFine   = stringToDate(dataFineAUX);
       		nuovo.setIdEvento(idEvento);
       		nuovo.setIdTipoEvento(idTipoEvento);
       		nuovo.setIdComune(idComune);
       		nuovo.setIdEnte(idEnte);
       		nuovo.setNomeEvento(nomeEvento);
       		nuovo.setDescEvento(descEvento);
       		nuovo.setDataFine(dataFine);
       		nuovo.setDataInizio(dataInizio);
       		nuovo.setCheck(checked);
        		
        }
        catch(SQLException e) {
        	e.printStackTrace();
        }
        
        return nuovo;	
   }
	
}

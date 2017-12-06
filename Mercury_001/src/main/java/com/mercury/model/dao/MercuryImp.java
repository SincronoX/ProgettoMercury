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
import com.mercury.model.TipoEvento;
import com.mercury.model.dao.DAO;

public class MercuryImp implements MercuryUtil{

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

	private boolean confrontoTipo(TipoEvento a, TipoEvento b) {
		if(a.getIdTipoEvento() == b.getIdTipoEvento()) return true;
		return false;
	}
	
	public ArrayList<EventoPrevisto> getRicerca(ArrayList<TipoEvento> tipi, String RicercaidComune, Calendar data) throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<EventoPrevisto> ret = new ArrayList<EventoPrevisto>();
		
		if(conn==null) conn=DAO.getConnection();
        Statement st = conn.createStatement();
        

        String query="SELECT * FROM mercury.eventoPrevisto where idEvento>0";
        int i;

        for(i=0; i<tipi.size(); i++) {
        	query += (" AND idTipoEvento != "+tipi.get(i).getIdTipoEvento());
        }
        
        // controllo sul luogo
        if(RicercaidComune != null) {
	        query += (" AND idComune = '" + RicercaidComune +"'");
        }
        
        // controllo sulla data
        if(data != null) {
	        String s = dateToString(data);
	        query += (" AND dataInizio = '" + s +"'");
        }
        
        
        // esegui query
        ResultSet rs = st.executeQuery(query);
        
        try {
        	while(rs.next()) {
        		EventoPrevisto nuovo = new EventoPrevisto();
        		
        		int idTipoEvento =     rs.getInt("idTipoEvento");
        		int idEvento =         rs.getInt("idEvento");
        		int idEnte =		   rs.getInt("idEnte");
        		String idComune =      rs.getString("idComune");
        		String nomeEvento =    rs.getString("nomeEvento");
        		String descEvento =    rs.getString("descrizione");
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
        		
        		ret.add(nuovo);
        	}        
        }
        catch(SQLException e) {
        	return new ArrayList<EventoPrevisto>();
        }
        
        return ret;
	}

	
	public ArrayList<EventoPrevisto> getEventiNotCheck() throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<EventoPrevisto> ret = new ArrayList<EventoPrevisto>();
		
		if(conn==null) conn=DAO.getConnection();
        Statement st = conn.createStatement();
        
        ResultSet rs = st.executeQuery("SELECT * FROM mercury.eventoprevisto where checked=0");
        try {
        	while(rs.next()) {
        		EventoPrevisto nuovo = new EventoPrevisto();
        		
        		int idTipoEvento =     rs.getInt("idTipoEvento");
        		int idEvento =         rs.getInt("idEvento");
        		int idEnte =		   rs.getInt("idEnte");
        		String idComune =      rs.getString("idComune");
        		String nomeEvento =    rs.getString("nomeEvento");
        		String descEvento =    rs.getString("descrizione");
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
        		
        		ret.add(nuovo);
        	}        
        }
        catch(SQLException e) {
        	return new ArrayList<EventoPrevisto>();
        }
        
        return ret;
	}


}
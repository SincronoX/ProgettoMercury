// Fabio Savelli

package com.mercury.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.mercury.model.Evento;
import com.mercury.model.Luogo;
import com.mercury.model.TipoEvento;
import com.mercury.model.dao.DAO;

public class MercuryImp implements MercuryUtil{

	Connection conn=null;
	
	public void sendNewsLetter() {
		// TODO Auto-generated method stub
		
	}
	
	private boolean confronto() {
		
		
	}
	
	public ArrayList<Evento> getRicerca(ArrayList<TipoEvento> tipi, Luogo posizione, Calendar data) throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<Evento> ret = new ArrayList<Evento>();
		
		if(conn==null) conn=DAO.getConnection();
        Statement st = conn.createStatement();
        
        TipoEventoImp tei = new TipoEventoImp();
        ArrayList<TipoEvento> listaTipi = tei.getEventoCatAll();

        for(int i=0; i<listaTipi.size(); i++) {
        	for(int j=0; j<tipi.size(); j++) {
        		if()
        	}
        	
        }
        
        
        ResultSet rs = st.executeQuery("SELECT * FROM mercury.eventoprevisto where checked=1");
        try {
        	while(rs.next()) {
        		Evento nuovo =         new Evento();
        		
        		int idTipoEvento =     rs.getInt("idTipoEvento");
        		int idEvento =         rs.getInt("idEvento");
        		String nomeEvento =    rs.getString("nomeEvento");
        		String descEvento =    rs.getString("descEvento");
        		String dataInizioAUX = rs.getString("dataInizio"); 
        		String dataFineAUX =   rs.getString("dateFine");
        		boolean check = 	   rs.getBoolean("check");
        		Calendar dataInizio = stringToDate(dataInizioAUX);
        		Calendar dataFine   = stringToDate(dataFineAUX);
        		
        		nuovo.setCheck(check);
        		nuovo.setDataFine(dataFine);
        		nuovo.setDataInizio(dataInizio);
        		nuovo.setDescEvento(descEvento);
        		nuovo.setIdEvento(idEvento);
        		nuovo.setNomeEvento(nomeEvento);
        		nuovo.setIdTipoEvento(idTipoEvento);
        		
        		ret.add(nuovo);
        	}        
        }
        catch(SQLException e) {
        	return new ArrayList<Evento>();
        }
        
        return ret;
	}

	
	private Calendar stringToDate(String s) {
		String[] aux = s.split(" - ");
		int anno = Integer.parseInt(aux[0]);
		int mese = Integer.parseInt(aux[1]) - 1;
		int giorno = Integer.parseInt(aux[2]);
		Calendar ret = new GregorianCalendar(anno, mese, giorno);
		return ret;
	}
	
	public ArrayList<Evento> getEventiNotCheck() throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<Evento> ret = new ArrayList<Evento>();
		
		if(conn==null) conn=DAO.getConnection();
        Statement st = conn.createStatement();
        
        ResultSet rs = st.executeQuery("SELECT * FROM mercury.eventoprevisto where checked=0");
        try {
        	while(rs.next()) {
        		Evento nuovo =         new Evento();
        		
        		int idTipoEvento =     rs.getInt("idTipoEvento");
        		int idEvento =         rs.getInt("idEvento");
        		String nomeEvento =    rs.getString("nomeEvento");
        		String descEvento =    rs.getString("descEvento");
        		String dataInizioAUX = rs.getString("dataInizio"); 
        		String dataFineAUX =   rs.getString("dateFine");
        		boolean check = 	   rs.getBoolean("check");
        		Calendar dataInizio = stringToDate(dataInizioAUX);
        		Calendar dataFine   = stringToDate(dataFineAUX);
        		
        		nuovo.setCheck(check);
        		nuovo.setDataFine(dataFine);
        		nuovo.setDataInizio(dataInizio);
        		nuovo.setDescEvento(descEvento);
        		nuovo.setIdEvento(idEvento);
        		nuovo.setNomeEvento(nomeEvento);
        		nuovo.setIdTipoEvento(idTipoEvento);
        		
        		ret.add(nuovo);
        	}        
        }
        catch(SQLException e) {
        	return new ArrayList<Evento>();
        }
        
        return ret;
	}


}
package com.mercury.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import com.mercury.model.dao.DAO;
import com.mercury.model.Ente;
import com.mercury.model.EventoPrevisto;
import com.mercury.model.dao.MercuryImp;

public class EnteImp implements EnteUtil {
	
	public ArrayList <EventoPrevisto> getEventiByEnte (String emailEnte){  //emailEnte verr� definito in servlet 
		String nomeEvento = null;
		String descrizione = null;
		Calendar dataInizio = null;
		Calendar dataFine = null;
		EventoPrevisto e = null;
		MercuryImp m = new MercuryImp();
		ArrayList<EventoPrevisto> eventi = new ArrayList<EventoPrevisto>();
		Connection conn=DAO.getConnection();
		String query="select * from eventoprevisto join ente on eventoprevisto.idEnte = ente.idEnte where emailEnte=?";
		PreparedStatement psEventi=null;
		try {
			psEventi = conn.prepareStatement(query);
			psEventi.setString(1,emailEnte);
			ResultSet rst=psEventi.executeQuery();
			while(rst.next()) {
				e = new EventoPrevisto();
				nomeEvento = rst.getString("nomeEvento");
				descrizione = rst.getString("descrizione");
				dataInizio = m.stringToDate(rst.getString("dataInizio"));
				dataFine = m.stringToDate(rst.getString("dataFine"));
				e.setNomeEvento(nomeEvento);
				e.setDescEvento(descrizione);
				e.setDataInizio(dataInizio);	
				e.setDataFine(dataFine);
				eventi.add(e);
				
			
			}
			}
			catch(SQLException exc)
			{
				exc.printStackTrace();
			}
		
		
		return eventi;
	}
	
	public boolean trovaEnte (Ente en) {
		boolean trovato = false;
		Connection conn=DAO.getConnection();
		String query="select * from ente where nomeEnte = ? or emailEnte = ?";
		String nome = en.getNomeEnte();
		String email = en.getEmailEnte();
		PreparedStatement psTrovaEnte=null;
		try {
			psTrovaEnte = conn.prepareStatement(query);
			psTrovaEnte.setString(1, nome);
			psTrovaEnte.setString(2, email);
			ResultSet rst=psTrovaEnte.executeQuery();
			if(rst.first()) {
				trovato = true;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return trovato;
	}
	
	public void addEnte(Ente en) {
		final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder builder = new StringBuilder();
		for ( int i = 0 ; i < 8 ; i++) {
			int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		String pass = builder.toString();
		Connection conn=DAO.getConnection();
		String queryAddEnte="insert into ente (nomeEnte,emailEnte,pswEnte,status,nBan) values (?,?,?,?,?)";
		PreparedStatement psAddEnte=null;
		try {
			psAddEnte = conn.prepareStatement(queryAddEnte);
			psAddEnte.setString(1, en.getNomeEnte());
			psAddEnte.setString(2, en.getEmailEnte());
			psAddEnte.setString(3, pass);
			psAddEnte.setString(4, "attesa");
			psAddEnte.setInt(5, 0);
			psAddEnte.executeUpdate();
			}
		catch(SQLException exc){
			exc.printStackTrace();
		}
	}
	
	public void inserisciEvento (EventoPrevisto e) {
		Connection conn = DAO.getConnection();
		MercuryImp m = new MercuryImp();
		String queryAddEvento = "insert into eventoprevisto (nomeEvento,dataInizio,dataFine,descrizione,checked) values (?,?,?,?,?)";
		PreparedStatement psAddEvento = null;
		try {
			psAddEvento = conn.prepareStatement(queryAddEvento);
			psAddEvento.setString(1, e.getNomeEvento());
			psAddEvento.setString(2, m.dateToString(e.getDataInizio()));
			psAddEvento.setString(3, m.dateToString(e.getDataFine()));
			psAddEvento.setString(4, e.getDescEvento());
			psAddEvento.setBoolean(5, false);
			psAddEvento.executeUpdate();
		}
		catch(SQLException exc){
			exc.printStackTrace();
		}
		
	}
	public void modificaEvento (EventoPrevisto e) {
		
	}

}

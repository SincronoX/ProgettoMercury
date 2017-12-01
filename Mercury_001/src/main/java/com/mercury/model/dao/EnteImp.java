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
	
	public ArrayList <EventoPrevisto> getEventiByEnte (String emailEnte){  //emailEnte verrà definito in servlet 
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
		Connection conn=DAO.getConnection();
		String insertUtente="insert into ente (nomeEnte,emailEnte,,email,dataNascita) values (?,?,?,?,?)";
		PreparedStatement psUtente=null;
		PreparedStatement psInd=null;
		PreparedStatement psPass=null;
		
	}
	
	public void inserisciEvento (Evento e) {
		
		
		
	}

}

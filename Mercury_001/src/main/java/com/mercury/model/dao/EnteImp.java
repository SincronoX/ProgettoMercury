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
	
	public ArrayList<EventoPrevisto> getEventiByEnte (String emailEnte){  //emailEnte verrà definito in servlet 
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
		Connection conn = DAO.getConnection();
		MercuryImp m = new MercuryImp();
		String queryModificaEvento = "update eventoprevisto set nomeEvento = ? , dataInizio = ? , dataFine = ? , descrizione = ? , checked = ? where idEvento = ?";
		PreparedStatement psModificaEvento = null;
		try {
			psModificaEvento = conn.prepareStatement(queryModificaEvento);
			psModificaEvento.setString(1, e.getNomeEvento());
			psModificaEvento.setString(2, m.dateToString(e.getDataInizio()));
			psModificaEvento.setString(3, m.dateToString(e.getDataFine()));
			psModificaEvento.setString(4, e.getDescEvento());
			psModificaEvento.setBoolean(5, false);
			psModificaEvento.setInt(6, e.getIdEvento());
			psModificaEvento.executeUpdate();
		}
		catch(SQLException exc) {
			exc.printStackTrace();
		}
	}
	
	public void eliminaEvento(EventoPrevisto e) {
		Connection conn = DAO.getConnection();
		MercuryImp m = new MercuryImp();
		EventoPrevisto ep = new EventoPrevisto();
		String queryCopiaEvento = " select * from eventoprevisto where idEvento = ?";
		String queryAddEvento = "insert into eventonascosto (nomeEvento,dataInizio,dataFine,descrizione,checked) values (?,?,?,?,?)";
		String queryEliminaEvento = "Delete * from eventoprevisto where idEvento = ?";
		PreparedStatement psCopiaEvento = null;
		PreparedStatement psAddEvento = null;
		PreparedStatement psEliminaEvento = null;
		try {
			psCopiaEvento = conn.prepareStatement(queryCopiaEvento);
			psAddEvento = conn.prepareStatement(queryAddEvento);
			psEliminaEvento = conn.prepareStatement(queryEliminaEvento);
			psCopiaEvento.setInt(1, ep.getIdEvento());
			ResultSet rst=psCopiaEvento.executeQuery();
			if(rst.first()) {
				ep.setIdEnte(rst.getInt("idUtente"));
				ep.setNomeEvento(rst.getString("nome"));
				ep.setDataInizio(m.stringToDate(rst.getString("dataInizio")));
				ep.setDataFine(m.stringToDate(rst.getString("dataFine")));
				ep.setDescEvento(rst.getString("descrizione"));
				ep.setCheck(rst.getBoolean("checked"));
				psAddEvento.setString(1, ep.getNomeEvento());
				psAddEvento.setString(2, m.dateToString(ep.getDataInizio()));
				psAddEvento.setString(3, m.dateToString(ep.getDataFine()));
				psAddEvento.setString(4, ep.getDescEvento());
				psAddEvento.setBoolean(5, true);
				psAddEvento.executeUpdate();
				psEliminaEvento.executeUpdate();
			}
		}
		catch(SQLException exc) {
			exc.printStackTrace();
		}
		
	}
	
	public Ente getEnteById(int id) {
		Ente e = new Ente();
		Connection conn=DAO.getConnection();
		String query="select * from ente where idEnte=?";
		PreparedStatement psId=null;
		try {
			psId = conn.prepareStatement(query);
			psId.setInt(1,id);
			ResultSet rst=psId.executeQuery();
			while(rst.first()) {
				
				e.setNomeEnte(rst.getString("nomeEnte"));
				e.setEmailEnte(rst.getString("emailEnte"));
				e.setPswEnte(rst.getString("pswEnte"));
				e.setStatus(rst.getString("status"));
				e.setnBan(rst.getInt("nBan"));
			}
		}
		catch(SQLException exc)
		{
			exc.printStackTrace();
		}
						
		return e;
		
	}
	
	public ArrayList<Ente> getEntiInAttesa(){
		ArrayList<Ente> enti = new ArrayList<Ente>();
		Ente e= null;
		Connection conn=DAO.getConnection();
		String query="select * from ente where status=?";
		PreparedStatement psEntiInAttesa=null;
		try {
			psEntiInAttesa = conn.prepareStatement(query);
			psEntiInAttesa.setString(1,"attesa");
			ResultSet rst=psEntiInAttesa.executeQuery();
			while(rst.next()) {
				e = new Ente();
				e.setNomeEnte(rst.getString("nomeEnte"));
				e.setEmailEnte(rst.getString("emailEnte"));
				e.setPswEnte(rst.getString("pswEnte"));
				e.setStatus(rst.getString("status"));
				e.setnBan(rst.getInt("nBan"));
				enti.add(e);
				
			
			}
			}
			catch(SQLException exc)
			{
				exc.printStackTrace();
			}
		
		
		return enti;
	}
		
		
		
		
	}
	
	
	




package com.mercury.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.mercury.model.dao.DAO;
import com.mercury.model.Ente;
import com.mercury.model.EventoPrevisto;
import com.mercury.model.dao.MercuryImp;

public class EnteImp implements EnteUtil {
	
	public Calendar stringToDate(String s) {
		String[] aux = s.split(" - ");
		int anno = Integer.parseInt(aux[0]);
		int mese = Integer.parseInt(aux[1]) - 1; 
		int giorno = Integer.parseInt(aux[2]);
		Calendar ret = new GregorianCalendar(anno, mese, giorno);
		return ret;
	}
	
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
<<<<<<< HEAD
=======
			psEventi.setString(1,emailEnte);
>>>>>>> 14ea08966074920330779020ac1e3e74a4fbe913
			ResultSet rst=psEventi.executeQuery();
			while(rst.next()) {
				e = new EventoPrevisto();
				nomeEvento = rst.getString("nomeEvento");
				descrizione = rst.getString("descrizione");
				dataInizio = stringToDate(rst.getString("dataInizio"));
				dataFine = stringToDate(rst.getString("dataFine"));
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
		String nome = en.getNomeEnte();
		String email = en.getEmailEnte();
		String query="select * from ente where nomeEnte = '"+nome+"' or emailEnte = '"+email+"'";
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
		String nome = en.getNomeEnte();
		String email= en.getEmailEnte();
		
		String queryAddEnte="insert into ente (nomeEnte,emailEnte,pswEnte,status,nBan) values ('"+nome+"','"+email+"','"+pass+"','attesa',0)";
		PreparedStatement psAddEnte=null;
		try {
			psAddEnte = conn.prepareStatement(queryAddEnte);
			psAddEnte.setString(4, "attesa");
			psAddEnte.setInt(5, 0);
			psAddEnte.executeUpdate();
			}
		catch(SQLException exc){
			exc.printStackTrace();
		}
	}
	
	public void inserisciEvento (EventoPrevisto e, int idEnte) {
		Connection conn = DAO.getConnection();
		MercuryImp m = new MercuryImp();
		String nomeEvento= e.getNomeEvento();
		String dataInizio= m.dateToString(e.getDataInizio());
		String dataFine= m.dateToString(e.getDataFine());
		String descEvento= e.getDescEvento();
		int TipoEvento= e.getIdTipoEvento();		
		String idComune= e.getIdComune();		
		System.out.println("ente "+idEnte);
		String queryAddEvento = "insert into mercury.eventoprevisto (nomeEvento, dataInizio,dataFine,descrizione,checked, idEnte, idTipoEvento, idComune) values ('"+nomeEvento+"','"+dataInizio+"','"+dataFine+"','"+descEvento+"',0,"+idEnte+","+TipoEvento+",'"+idComune+"')";
		Statement psAddEvento = null;
		try {
			psAddEvento = conn.createStatement();		
			psAddEvento.executeUpdate(queryAddEvento);
		}
		catch(SQLException exc){
			exc.printStackTrace();
		}
		
	}
	public void modificaEvento (EventoPrevisto e) {
		Connection conn = DAO.getConnection();
		MercuryImp m = new MercuryImp();
		String nomeEvento= e.getNomeEvento();
		String dataInizio= m.dateToString(e.getDataInizio());
		String dataFine= m.dateToString(e.getDataFine());
		String descEvento= e.getDescEvento();
		int tipoEvento= e.getIdTipoEvento();
		String idComune= e.getIdComune();
		int idEvento= e.getIdEvento();
		String queryModificaEvento = "update eventoprevisto set nomeEvento = '"+nomeEvento+"' , dataInizio = '"+dataInizio+"' , dataFine = '"+dataFine+"' , descrizione = '"+descEvento+"' , checked = 'false', idTipoEvento = '"+tipoEvento+"', idComune = "+idComune+" where idEvento = "+idEvento;
		PreparedStatement psModificaEvento = null;
		try {
			psModificaEvento = conn.prepareStatement(queryModificaEvento);		
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
<<<<<<< HEAD
		String queryCopiaEvento = "select * from eventoprevisto where idEvento = "+e.getIdEvento();
		String queryAddEvento = "insert into eventonascosto (nomeEvento,dataInizio,dataFine,descrizione,checked, idEnte, idTipoEvento, idComune) values (";
		String queryEliminaEvento = "Delete from eventoprevisto where idEvento = "+e.getIdEvento();
=======
		String queryCopiaEvento = " select * from eventoprevisto where idEvento = ?";
		String queryAddEvento = "insert into eventonascosto (nomeEvento,dataInizio,dataFine,descrizione,checked, idEnte, idTipoEvento, idComune) values (?,?,?,?,?,?,?,?)";
		String queryEliminaEvento = "Delete * from eventoprevisto where idEvento = ?";
>>>>>>> 14ea08966074920330779020ac1e3e74a4fbe913
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
				ep.setIdComune(rst.getString("idComune"));
				ep.setIdTipoEvento(Integer.parseInt(rst.getString("idTipoEvento")));
<<<<<<< HEAD
				
				queryAddEvento += ("'"+ep.getNomeEvento()+"', ");
				queryAddEvento += ("'"+m.dateToString(ep.getDataInizio())+"', ");
				queryAddEvento += ("'"+m.dateToString(ep.getDataFine())+"', ");
				queryAddEvento += ("'"+ep.getDescEvento()+"', ");
				queryAddEvento += (1+", ");
				queryAddEvento += (e.getIdEnte()+", ");
				queryAddEvento += (e.getIdTipoEvento()+", ");
				queryAddEvento += ("'"+e.getIdComune()+"')");

				psAddEvento = conn.prepareStatement(queryAddEvento);

=======
				psAddEvento.setString(1, ep.getNomeEvento());
				psAddEvento.setString(2, m.dateToString(ep.getDataInizio()));
				psAddEvento.setString(3, m.dateToString(ep.getDataFine()));
				psAddEvento.setString(4, ep.getDescEvento());
				psAddEvento.setBoolean(5, true);
				psAddEvento.setInt(6, e.getIdEnte());
				psAddEvento.setInt(7, e.getIdTipoEvento());
				psAddEvento.setString(8, e.getIdComune());
>>>>>>> 14ea08966074920330779020ac1e3e74a4fbe913
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
		String query="select * from ente where idEnte="+id; 
		PreparedStatement psId=null;
		try {
			psId = conn.prepareStatement(query);
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
		String query="select * from ente where status='attesa'";
		PreparedStatement psEntiInAttesa=null;
		try {
			psEntiInAttesa = conn.prepareStatement(query);
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
		
	public boolean controlloLoginEnte (String email, String psw) {
		boolean trovato = false;
		Connection conn=DAO.getConnection();
<<<<<<< HEAD
		String query="select * from ente where emailEnte = '"+email+"' and pswEnte = '"+psw+"'";
=======
		Ente en = new Ente();
		String query="select * from ente where emailEnte = ? and pswEnte = ?";
>>>>>>> 14ea08966074920330779020ac1e3e74a4fbe913
		PreparedStatement psControlloLoginEnte=null;
		try {
			psControlloLoginEnte = conn.prepareStatement(query);
			ResultSet rst=psControlloLoginEnte.executeQuery();
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
	public Ente getEnteByEmail(String email) {
	Ente e = new Ente();
	Connection conn=DAO.getConnection();
	String query="select * from ente where emailEnte=?";
	PreparedStatement psEm=null;
	try {
		psEm = conn.prepareStatement(query);
<<<<<<< HEAD
		ResultSet rst=psEm.executeQuery();
		if(rst.first()) {
			e.setIdEnte(Integer.parseInt(rst.getString("idEnte")));
=======
		psEm.setString(1,email);
		ResultSet rst=psEm.executeQuery();
		while(rst.first()) {
			
>>>>>>> 14ea08966074920330779020ac1e3e74a4fbe913
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
		
		
	}

	
	
	




package com.mercury.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mercury.model.TipoEvento;
import com.mercury.model.Utente;

public class UtenteImp implements UtenteUtil {
	
	Connection conn = null;
	
	public int getIdUtente (String emailUtente) throws SQLException {
		
		if (conn == null)
			conn = DAO.getConnection();
			String query="select idUtente from utente where emailUtente = ?";
			
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, emailUtente);
			ResultSet rst = st.executeQuery();
			
			if (rst.first())
				return rst.getInt("idUtente");
			else {
				return -1;
			}
		
	}

	
	public void addUtente (String emailUtente, int idCadenza, String idComune, ArrayList<Integer> preferenze) throws SQLException {
		
	if (conn == null)
		conn = DAO.getConnection(); 
	
		String query="insert into utente (emailUtente, idComune, idCadenza) values (?,?,?)";
		
		PreparedStatement st = conn.prepareStatement(query);
		st.setString(1, emailUtente);
		st.setString(2, idComune);
		st.setInt(3, idCadenza);
		st.executeUpdate();
		
		int idUtente = this.getIdUtente(emailUtente);
		for(int i=0; i<preferenze.size(); i++)
		{
			String qPrefTipo="insert into prefTipo (idTipoEvento, idUtente) values (?,?)";
			PreparedStatement ps = conn.prepareStatement(qPrefTipo);
			ps.setInt(1, preferenze.get(i));
			ps.setInt(2, idUtente);
			ps.executeUpdate();
		}
		
		
	}

	
	public int checkMail (String emailUtente, int idCadenza, String idComune, ArrayList<Integer> preferenze) throws SQLException {
	
	if (conn == null)
		conn = DAO.getConnection();
		String query="select * from utente where emailUtente = ?";
		
		PreparedStatement st = conn.prepareStatement(query);
		st.setString(1, emailUtente);
		ResultSet rst = st.executeQuery();
		
		if (rst.first())
			return -1;
		else
		{
			this.addUtente(emailUtente, idCadenza, idComune, preferenze);
			return 0;
		}
		
		

	}


	public Utente getUtenteById(int idUtente) {
		Utente x= new Utente();
		x.setIdUtente(idUtente);
		Connection conn = DAO.getConnection();		
		String query="select * from utente u where u.idUtente = "+idUtente +";" ;
		ResultSet rs;
		try {
			rs = DAO.execute_Query(conn, query );
			if(rs.first()==true) 
			{		
				x.setEmailUtente(rs.getString("emailUtente"));
				x.setIdCadenza(Integer.parseInt(rs.getString("idCadenza")));
				x.setIdComune(rs.getString("idComune"));
			}

		}catch (SQLException e) {
			e.printStackTrace();
		}
		return x;
	}


	public boolean trovaUtente(String email) {
		boolean x = false ;
		Connection conn = DAO.getConnection();		
		String query="select * from utente u where u.emailUtente = '"+email +"';" ;
		ResultSet rs;
		try {
			rs = DAO.execute_Query(conn, query );
			if(rs.first()==true) 
			{		
				x= true;
			}
			else 
			{
				x= false ;
			}

		}catch (SQLException e) {
			e.printStackTrace();
		}
		return x;
	}
	
				
	
				
}
				


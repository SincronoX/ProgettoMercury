package com.mercury.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mercury.model.Regione;

public class RegioneImp implements RegioneUtil {
	
	Connection conn = null;
	
	public Regione getRegioneById(int id) throws SQLException 
	{
		if (conn==null)
		{
			conn = DAO.getConnection();
		}
		
		Regione x = new Regione();
		
		Statement st = conn.createStatement();
		
		ResultSet rs = st.executeQuery("select * from mercury.Regione r where r.idRegione = "+ id+";");
		
		try 
		{
			rs.next();			
			
			String nomeRegione = rs.getString("nomeRegione");
			
			x.setNomeRegione(nomeRegione);			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
				
		return x;
	}
		
}

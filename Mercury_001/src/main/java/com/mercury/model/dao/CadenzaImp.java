package com.mercury.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mercury.model.Cadenza;



public class CadenzaImp implements CadenzaUtil {
	
	Connection conn = null;
	
	public Cadenza getCadenzaById(int id) throws SQLException
	{
		if(conn==null) conn=DAO.getConnection();
        Statement st = conn.createStatement();
        
        ResultSet rs = st.executeQuery("SELECT * FROM mercury.cadenza where idCadenza = "+id);
        
        Cadenza x  = new Cadenza();
        
        
        try {
        	rs.first();
        	
        	String frequenza = rs.getString("frequenza"); 
        	
        	x.setFrequenza(frequenza);
        }
        catch (Exception e)
        {
        	e.printStackTrace();
        }
        
        return x;
	
	}

}

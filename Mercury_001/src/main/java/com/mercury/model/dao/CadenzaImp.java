package com.mercury.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
<<<<<<< HEAD
import java.sql.Statement;

import com.mercury.model.Cadenza;


=======

import com.mercury.model.Cadenza;
import com.mercury.model.TipoEvento;
>>>>>>> branch 'master' of https://github.com/SincronoX/ProgettoMercury.git

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

	public Cadenza getCadenzaById(int id) {
		Cadenza x= new Cadenza();
		x.setIdCadenza(id);
		Connection conn = DAO.getConnection();		
		String query="select * from cadenza c where c.idCadenza = "+id +";" ;
		ResultSet rs;
		try {
			rs = DAO.execute_Query(conn, query );
			if(rs.first()==true) 
			{		
				x.setFrequenza(rs.getString("frequenza"));
			}

		}catch (SQLException e) {
			e.printStackTrace();
		}
		return x;
	}

}

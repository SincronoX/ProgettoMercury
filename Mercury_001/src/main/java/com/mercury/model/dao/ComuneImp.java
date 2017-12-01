// Fabio Savelli

package com.mercury.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mercury.model.Comune;

public class ComuneImp implements ComuneUtil {

	Connection conn = null;
	
	
	public String getIdComune(String regione, String provincia, String comune) {
		// TODO Auto-generated method stub
		return "";
	}

	public Comune getComuneById(String id) throws SQLException {
		// TODO Auto-generated method stub
		if(conn==null) conn=DAO.getConnection();
        Statement st = conn.createStatement();
        
        ResultSet rs = st.executeQuery("SELECT * FROM mercury.eventoprevisto where idEvento = "+id);
        
        Comune nuovo = new Comune();
        
        try {
        	rs.first();
       		
       		String idComune =     rs.getString("idComune");
       		String nomeComune =   rs.getString("nomeComune");
       		
       		nuovo.setIdComune(idComune);
       		nuovo.setNomeComune(nomeComune);
       		
        }catch (Exception e) {
			// TODO: handle exception
        	e.printStackTrace();
		}
        return nuovo;
	}

}

package com.mercury.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mercury.model.Cadenza;


import com.mercury.model.Cadenza;
import com.mercury.model.TipoEvento;

public class CadenzaImp implements CadenzaUtil {
	

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

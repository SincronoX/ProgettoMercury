
package com.mercury.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mercury.model.Evento;
import com.model.DAO;

public class TipoEventoImp implements TipoEventoUtil {

	public ArrayList<Evento> getEvento() {
		ArrayList<Evento> lista;
		Connection conn = DAO.getConnection();		
		String query="select * from Evento" ;
		try {
			ResultSet rs= DAO.execute_Query(conn, query );
			while(rs.next()==true) 
				{
				
				
				}
			}
		
		
		
		
		
		
		return lista;
	}

}

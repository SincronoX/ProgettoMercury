
package com.mercury.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mercury.model.Evento;


public class TipoEventoImp implements TipoEventoUtil {

	public ArrayList<Evento> getEventoCat(String cat) {
		ArrayList<Evento> lista=null;
		Connection conn = DAO.getConnection();		
		String query="select e.* from evento e, tipoevento te where e.idTipoEvento= te.idTipoEvento and te.catEvento = "+cat+";" ;
		ResultSet rs;
		try {
			rs = DAO.execute_Query(conn, query );

			while(rs.next()==true) 
			{
				/*	nomeEvento
					dataInizio
					dataFine
					descrizione
					*/int x ;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}






		return lista;
	}

	
	
	public ArrayList<Evento> getEventoAll() {
			return null;
	}

	
	
	
}

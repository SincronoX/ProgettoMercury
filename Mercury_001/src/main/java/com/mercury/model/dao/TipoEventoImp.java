
package com.mercury.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;

import com.mercury.model.Evento;
import com.mercury.model.TipoEvento;


public class TipoEventoImp implements TipoEventoUtil {

	public ArrayList<TipoEvento> getEventoCatAll() {
		ArrayList<TipoEvento> lista = new ArrayList<TipoEvento>();
		TipoEvento x = null;
		Connection conn = DAO.getConnection();		
		String query="select * from tipoevento ;" ;
		ResultSet rs;
		try {
			rs = DAO.execute_Query(conn, query );
			while(rs.next()==true) 
			{		
			x= new TipoEvento();
			x.setIdTipoEvento(rs.getInt("idTipoEvento"));
			x.setCatEvento(rs.getString("catEvento"));
			lista.add(x);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}


	
	public ArrayList<Evento> getEventoCat(String cat) {
		ArrayList<Evento> lista= new ArrayList<Evento>();
		Evento x = null;
		Connection conn = DAO.getConnection();		
		String query="select e.* from evento e, tipoevento te where e.idTipoEvento= te.idTipoEvento and te.catEvento = "+cat+";" ;
		ResultSet rs;
		try {
			rs = DAO.execute_Query(conn, query );
			while(rs.next()==true) 
			{	x= new Evento();
				x.setIdEvento(rs.getInt("idEvento"));
				x.setDataInizio(rs.getCalendar("dataInizio"));
				x.setDataFine(rs.getCalendar("dataFine"));
				x.setNomeEvento(rs.getString("nomeEvento"));
				(rs.getCalendar("dataInizio"));
				(rs.getInt("dataFine"));
				(rs.getInt("descEvento"));
				(rs.getInt("checked"));
				(rs.getInt("idTipoEvento"));



			}
		} catch (SQLException e) {
			e.printStackTrace();
		}



		return lista;


	}







}

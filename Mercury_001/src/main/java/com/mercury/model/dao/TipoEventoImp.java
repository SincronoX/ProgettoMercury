
package com.mercury.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;

import com.mercury.model.EventoPrevisto;
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


	
	public ArrayList<EventoPrevisto> getEventoCatPrevisto(String cat) {
		ArrayList<EventoPrevisto> lista= new ArrayList<EventoPrevisto>();
		EventoPrevisto x = null;
		Connection conn = DAO.getConnection();		
		String query="select e.* from evento e, tipoevento te where e.idTipoEvento= te.idTipoEvento and te.catEvento = '"+cat+"';" ;
		ResultSet rs;
		MercuryImp conv = null;
		try {
			rs = DAO.execute_Query(conn, query );
			while(rs.next()==true) 
			{	x= new EventoPrevisto();
				x.setIdEvento(rs.getInt("idEvento"));
				String LADataInizio=(rs.getString("dataInizio"));
				String LADataFine=(rs.getString("dataFine"));
				x.setDataInizio(conv.stringToDate(LADataInizio));
				x.setDataFine(conv.stringToDate(LADataFine));
				x.setNomeEvento(rs.getString("nomeEvento"));
				x.setDescEvento(rs.getString("descEvento"));
				x.setCheck(rs.getBoolean("checked"));
				x.setIdTipoEvento(rs.getInt("idTipoEvento"));
				x.setIdEnte(rs.getInt("idEnte"));
				x.setIdComune(rs.getString("idComune"));
				lista.add(x);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;


	}



	public TipoEvento getTipoEventoById(int idEvento) {
		TipoEvento x= new TipoEvento();
		x.setIdTipoEvento(idEvento);
		Connection conn = DAO.getConnection();		
		String query="select * from tipoevento t where t.idTipoEvento = "+idEvento +";" ;
		ResultSet rs;
		try {
			rs = DAO.execute_Query(conn, query );
			if(rs.first()==true) 
			{		
				x.setCatEvento(rs.getString("catEvento"));
			}

		}catch (SQLException e) {
			e.printStackTrace();
		}
		return x;



	}
}

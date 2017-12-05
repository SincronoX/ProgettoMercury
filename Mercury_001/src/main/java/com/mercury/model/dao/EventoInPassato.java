// Fabio Savelli

package com.mercury.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class EventoInPassato  extends Thread implements Runnable{
		
	Connection conn=null;
	
	public EventoInPassato() {
		super();
	}

	public void run() {
		while(true) {
			DateFormat dateFormat = new SimpleDateFormat("yyyy - MM - dd");
			Calendar cal = Calendar.getInstance();
			
			if(conn==null) conn=DAO.getConnection();
			
	        try {
				Statement st = conn.createStatement();
		        String query="SELECT * FROM mercury.eventoprevisto where dataFine < '"+dateFormat.format(cal)+"'";
		        ResultSet rs = st.executeQuery(query); 
		        while(rs.next()) {
		        	String query2 = "INSERT INTO mercury.eventopassato (nomeEvento, dataInizio, dataFine, descrizione, checked, ideEnte, idTipoEvento, idComune) values (";
		        	query2 += (rs.getString("nomeEvento")+", ");
		        	query2 += (rs.getString("dataInizio")+", ");
		        	query2 += (rs.getString("dataFine")+", ");
		        	query2 += (rs.getString("descrizione")+", ");
		        	query2 += (rs.getInt("checked")+", ");
		        	query2 += (rs.getInt("idEnte")+", ");
		        	query2 += (rs.getInt("idTipoEvento")+", ");
		        	query2 += (rs.getString("idComune")+", ");
		        	
		        	st.executeUpdate(query2);
		        }
		        String query3 = "DELETE FROM mercury.eventoprevisto where dataFine < '"+dateFormat.format(cal)+"'";
		        st.executeUpdate(query3);
	        
	        } catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        			
			try {
				Thread.sleep(86400);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

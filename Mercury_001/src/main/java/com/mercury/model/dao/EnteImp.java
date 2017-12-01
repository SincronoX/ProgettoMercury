package com.mercury.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.mercury.model.dao.DAO;
import com.mercury.model.Evento;

public class EnteImp implements EnteUtil {
	
	public ArrayList <Evento> getEventiByEnte (String emailEnte){  //emailEnte verrà definito in servlet 
		String nomeEvento = null;
		String descrizione = null;
		String dataInizio = null;
		String dataFine = null;
		Evento e = null;
		ArrayList<Evento> eventi = new ArrayList<Evento>();
		Connection conn=DAO.getConnection();
		String query="select * from eventoprevisto join ente on eventoprevisto.idEnte = ente.idEnte where emailEnte=?";
		PreparedStatement psEventi=null;
		try {
			psEventi = conn.prepareStatement(query);
			psEventi.setString(1,emailEnte);
			ResultSet rst=psEventi.executeQuery();
			while(rst.next()) {
				e = new Evento();
				nomeEvento = rst.getString("nomeEvento");
				descrizione = rst.getString("descrizione");
				dataInizio = rst.getString("dataInizio");
				dataFine = rst.getString("dataFine");
				e.setNomeEvento(nomeEvento);
				e.setDescEvento(descrizione);
				//e.setDataInizio(dataInizio);	//Convertire data da stringa in Date
				
				eventi.add(e);
				
			
			}
			}
		
		
		return eventi;
	}

}

// Fabio Savelli

package com.mercury.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import com.mercury.model.Evento;
import com.mercury.model.Luogo;
import com.mercury.model.TipoEvento;

public interface MercuryUtil {
	
	void sendNewsLetter(); 
	ArrayList<Evento> getRicerca(ArrayList<TipoEvento> tipi, Luogo posizione, Calendar data) throws SQLException; 
	ArrayList<Evento> getEventiNotCheck() throws SQLException;
}
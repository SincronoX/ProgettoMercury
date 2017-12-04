// Fabio Savelli

package com.mercury.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import com.mercury.model.EventoPrevisto;
import com.mercury.model.TipoEvento;

public interface MercuryUtil {
	
	ArrayList<EventoPrevisto> getRicerca(ArrayList<TipoEvento> tipi, String RicercaidComune, Calendar data) throws SQLException; 
	ArrayList<EventoPrevisto> getEventiNotCheck() throws SQLException;
}
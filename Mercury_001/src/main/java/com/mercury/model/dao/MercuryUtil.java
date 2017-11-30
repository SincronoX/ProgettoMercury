// Fabio Savelli

package com.mercury.model.dao;

import java.util.ArrayList;
import java.util.Date;

import com.mercury.model.Evento;
import com.mercury.model.Luogo;
import com.mercury.model.TipoEvento;

public interface MercuryUtil {
	
	void sendNewsLetter(); 
	ArrayList<Evento> getRicerca(ArrayList<TipoEvento> tipi, Luogo posizione, Date data); 
	ArrayList<Evento> getEventiNotCheck();
}

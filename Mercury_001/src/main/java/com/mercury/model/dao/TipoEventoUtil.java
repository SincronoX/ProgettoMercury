
package com.mercury.model.dao;
import java.util.ArrayList;
import com.mercury.model.Evento;
import com.mercury.model.TipoEvento;

public interface TipoEventoUtil {

	ArrayList <TipoEvento> getEventoCatAll (); // restituisce le categorie esistenti
	ArrayList <Evento> getEventoCat (String cat); // restituisce gli eventi
	
	
}

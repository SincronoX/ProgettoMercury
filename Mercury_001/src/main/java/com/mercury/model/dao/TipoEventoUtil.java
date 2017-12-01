
package com.mercury.model.dao;
import java.util.ArrayList;
import com.mercury.model.Evento;
import com.mercury.model.TipoEvento;

public interface TipoEventoUtil {

	ArrayList <TipoEvento> getEventoCatAll (); // restituisce i tipi di evento esistenti
	ArrayList <Evento> getEventoCat (String cat); // restituisce gli eventi
	
	
}

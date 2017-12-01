
package com.mercury.model.dao;
import java.util.ArrayList;
import com.mercury.model.EventoPrevisto;
import com.mercury.model.TipoEvento;

public interface TipoEventoUtil {

	ArrayList <TipoEvento> getEventoCatAll (); // restituisce i tipi di evento esistenti
	ArrayList <EventoPrevisto> getEventoCatPrevisto (String cat); // restituisce gli eventi
	TipoEvento getEventoById(int idEvento); //
	
}

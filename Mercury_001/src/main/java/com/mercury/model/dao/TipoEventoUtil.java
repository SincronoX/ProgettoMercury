
package com.mercury.model.dao;
import java.util.ArrayList;
import com.mercury.model.EventoPrevisto;
import com.mercury.model.TipoEvento;

public interface TipoEventoUtil {

	public ArrayList <TipoEvento> getEventoCatAll (); // restituisce i tipi di evento esistenti
	public ArrayList <EventoPrevisto> getEventoCatPrevisto (String cat); // restituisce gli eventi
	public TipoEvento getTipoEventoById(int idEvento); //
	
}


package com.mercury.model.dao;
import java.util.ArrayList;
import com.mercury.model.Evento;

public interface TipoEventoUtil {

	ArrayList <Evento> getEventoCatAll (String cat); // restituisce le categorie esistenti
	ArrayList <Evento> getEventoCat (); // restituisce gli eventi
	
	
}

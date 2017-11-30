
package com.mercury.model.dao;
import java.util.ArrayList;
import com.mercury.model.Evento;

public interface TipoEventoUtil {

	ArrayList <Evento> getEventoAll ();
	ArrayList <Evento> getEventoCat (String cat);
	
	
}

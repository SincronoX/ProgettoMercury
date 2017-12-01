// Fabio Savelli

package com.mercury.model.dao;

import com.mercury.model.EventoNascosto;

public interface EventoNascostoUtil {
	public String toString(String nomeEvento, int idEvento);
	
	public EventoNascosto getEventoNascostoById(int id);
}

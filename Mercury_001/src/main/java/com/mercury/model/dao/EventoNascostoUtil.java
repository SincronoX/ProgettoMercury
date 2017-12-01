// Fabio Savelli

package com.mercury.model.dao;

import java.sql.SQLException;

import com.mercury.model.EventoNascosto;

public interface EventoNascostoUtil {
	public String toString(String nomeEvento, int idEvento);
	
	public EventoNascosto getEventoNascostoById(int id) throws SQLException;
}

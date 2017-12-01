// Fabio Savelli

package com.mercury.model.dao;

import java.sql.SQLException;

import com.mercury.model.EventoPassato;

public interface EventoPassatoutil {
	public String toString(String nomeEvento, int idEvento);
	public EventoPassato getEventoPassatoById(int id) throws SQLException;
}

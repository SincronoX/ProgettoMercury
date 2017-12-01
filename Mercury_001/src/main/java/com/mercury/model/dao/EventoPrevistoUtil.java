// Fabio Savelli

package com.mercury.model.dao;

import java.sql.SQLException;

import com.mercury.model.EventoPrevisto;

public interface EventoPrevistoUtil {
	public String toString(String nomeEvento, int idEvento);
	public EventoPrevisto getEventoPrevistoById(int id) throws SQLException;
}

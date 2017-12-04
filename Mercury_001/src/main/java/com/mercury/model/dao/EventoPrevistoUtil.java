// Fabio Savelli

package com.mercury.model.dao;

import java.sql.SQLException;
import java.util.Calendar;

import com.mercury.model.EventoPrevisto;

public interface EventoPrevistoUtil {
	public Calendar stringToDate(String s);
	public String dateToString(Calendar c);
	public String toString(String nomeEvento, int idEvento);
	public EventoPrevisto getEventoPrevistoById(int id) throws SQLException;
}

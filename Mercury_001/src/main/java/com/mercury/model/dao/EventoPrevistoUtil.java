// Fabio Savelli

package com.mercury.model.dao;

import com.mercury.model.EventoPrevisto;

public interface EventoPrevistoUtil {
	public String toString(String nomeEvento, int idEvento);
	public EventoPrevisto getEventoPrevistoById(int id);
}

package com.mercury.model.dao;

import java.sql.SQLException;

public interface UtenteUtil {
	
	
	public int checkMail (String emailUtente, int idCadenza, String idComune, int[] preferenze) throws SQLException;
	
	public void addUtente (String emailUtente, int idCadenza, String idComune, int[] preferenze) throws SQLException;
	
	public int getIdUtente (String emailUtente) throws SQLException;
	
	
	
}

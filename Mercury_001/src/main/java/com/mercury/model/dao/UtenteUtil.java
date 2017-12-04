package com.mercury.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface UtenteUtil {
	
	
	public int checkMail (String emailUtente, int idCadenza, String idComune, ArrayList<Integer> preferenze) throws SQLException;
	
	public void addUtente (String emailUtente, int idCadenza, String idComune, ArrayList<Integer> preferenze) throws SQLException;
	
	public int getIdUtente (String emailUtente) throws SQLException;
	
	
	
}

package com.mercury.model.dao;

import java.sql.SQLException;

import com.mercury.model.Regione;

public interface RegioneUtil {
	
	public Regione getRegioneById (int id) throws SQLException;

}

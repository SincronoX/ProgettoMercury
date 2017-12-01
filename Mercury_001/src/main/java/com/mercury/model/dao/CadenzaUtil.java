package com.mercury.model.dao;



import java.sql.SQLException;

import com.mercury.model.Cadenza;

public interface CadenzaUtil {

	public Cadenza getCadenzaById(int id) throws SQLException;
	
}

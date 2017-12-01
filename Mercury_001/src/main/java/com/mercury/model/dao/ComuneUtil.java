// Fabio Savelli

package com.mercury.model.dao;

import com.mercury.model.Comune;

public interface ComuneUtil {
	public String getIdComune(String regione, String provincia, String comune);
	public Comune getComuneById(String id);
}

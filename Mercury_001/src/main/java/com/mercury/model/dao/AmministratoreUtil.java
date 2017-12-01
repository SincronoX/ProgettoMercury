package com.mercury.model.dao;

import com.mercury.model.Ente;
import com.mercury.model.EventoPrevisto;

public interface AmministratoreUtil {
	

	//l'amministratore abilità l'iscrizione dell'Ente
	public void abilitaEnte(String email, String nome);

	//  ??
	public void confermaMail();
	
	//l'amministratore controlla l'evento ed eventualmente lo banna
	public void checkEvento(EventoPrevisto ep, Ente en) ;

}

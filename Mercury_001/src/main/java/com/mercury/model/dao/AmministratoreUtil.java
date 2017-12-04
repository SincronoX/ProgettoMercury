package com.mercury.model.dao;

//

import com.mercury.model.Amministratore;
import com.mercury.model.Ente;
import com.mercury.model.EventoPrevisto;

public interface AmministratoreUtil {
	
	public boolean trovaAdmin(String email , String psw);
	
	//l'amministratore abilità l'iscrizione dell'Ente 
	public void InvioMailAbilitaEnte(Ente en);
	/* prende mail e nome i8nserito in fase di registrazione dall'ente
	 * controlla se tale nome ed email già esiste nel database rifiuta la registrazione
	 * altrimenti cambio status dell?Ente da "attesa" a "attivo" dopo chiama il metodo
	 * conferma mail e gli manda lapassword generata automaticamente via mail */

	
	public void mailBanEvento(Ente en);
	public void mailBanEnte(Ente en);
	
	//l'amministratore controlla l'evento ed eventualmente lo banna
	public void checkEvento(EventoPrevisto ep,  boolean ok);
	
	public Amministratore getAdminById(int id);

}

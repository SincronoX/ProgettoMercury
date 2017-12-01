package com.mercury.model;

public class Amministratore {
	
	private String pswAdmin = null;
	private String emailAdmin = null;
	
	public Amministratore () {
		super();
	}
	
	public void abilitaEnte(String email, String nome) {
		
	}
	
	public void confermaMail() {
		
	}
	
	public void checkEvento(Evento ev, int idEnte, boolean v) {
		
		/*Banna Utente
		 * Cancella Evento
		 * Set Check
		 */
		
	}
	
	
	public String getPswAdmin() {
		return pswAdmin;
	}
	public void setPswAdmin(String pswAdmin) {
		this.pswAdmin = pswAdmin;
	}
	public String getEmailAdmin() {
		return emailAdmin;
	}
	public void setEmailAdmin(String emailAdmin) {
		this.emailAdmin = emailAdmin;
	}
	
	

}

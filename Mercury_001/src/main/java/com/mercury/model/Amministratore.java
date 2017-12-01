package com.mercury.model;

public class Amministratore {
	
	private String pswAdmin = null;
	private String emailAdmin = null;
	
	public Amministratore () {
		super();
	}
	
	//l'amministratore abilità l'iscrizione dell'Ente
	public void abilitaEnte(String email, String nome) {
		
	}

	public void confermaMail() {
		
	}
	
	//l'amministratore controllo l'evento eventualmente lo banna
	public void checkEvento(EventoPrevisto ep, Ente en) {
		
		
		
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

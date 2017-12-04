package com.mercury.model;

public class Utente {
	
	private int idUtente = 0 ;
	private String emailUtente = null;
	private String idComune = null ;
	private int idCadenza = 0 ;
	
	public int getIdUtente() {
		return idUtente;
	}
	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}
	public String getEmailUtente() {
		return emailUtente;
	}
	public void setEmailUtente(String emailUtente) {
		this.emailUtente = emailUtente;
	}
	public String getIdComune() {
		return idComune;
	}
	public void setIdComune(String idComune) {
		this.idComune = idComune;
	}
	public int getIdCadenza() {
		return idCadenza;
	}
	public void setIdCadenza(int idCadenza) {
		this.idCadenza = idCadenza;
	}


}

package com.mercury.model;

public class Amministratore {
	// o
	
	private int idAdmin =0 ;
	private String emailAdmin = null;
	private String pswAdmin = null;
	
	
	public Amministratore () {
		super();
	}
	
	
	public int getIdAdmin() {
		return idAdmin;
	}


	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
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

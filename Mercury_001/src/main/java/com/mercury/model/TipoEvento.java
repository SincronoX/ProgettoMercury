package com.mercury.model;

public class TipoEvento {

	private int 	idEnte 		= 0;
	private String 	nomeEnte	= null;
	private String  emailEnte	= null;
	private String  pswEnte		= null;
	private int 	nBan		= 0;
	private String 	status		= "attesa";
	
public TipoEvento() 
{ 	
	super();
}
	
	public int getIdEnte() {
		return idEnte;
	}

	public String getNomeEnte() {
		return nomeEnte;
	}

	public void setNomeEnte(String nomeEnte) {
		this.nomeEnte = nomeEnte;
	}

	public String getEmailEnte() {
		return emailEnte;
	}

	public void setEmailEnte(String emailEnte) {
		this.emailEnte = emailEnte;
	}

	public String getPswEnte() {
		return pswEnte;
	}

	public void setPswEnte(String pswEnte) {
		this.pswEnte = pswEnte;
	}

	public int getnBan() {
		return nBan;
	}

	public void setnBan(int nBan) {
		this.nBan = nBan;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}

	
	
}


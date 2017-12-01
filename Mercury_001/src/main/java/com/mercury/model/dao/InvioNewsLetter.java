package com.mercury.model.dao;

import java.util.Date;
import java.util.TimerTask;

public class InvioNewsLetter extends TimerTask {
	Date now;
	int idUtente;
	
	public InvioNewsLetter(int idUtente) {
		super();
		this.idUtente = idUtente;
	}


	public void run() {
		now = new Date();
		// Invio Email
		
		
		
	}
}

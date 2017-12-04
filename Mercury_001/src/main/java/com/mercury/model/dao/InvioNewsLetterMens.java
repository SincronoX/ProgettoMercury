package com.mercury.model.dao;

import java.sql.SQLException;
import java.util.Date;

public class InvioNewsLetterMens extends Thread implements Runnable {
	
	Date now;
	String utente;
	
	public InvioNewsLetterMens() {
		super();


	}
	
	public void run() {
		while(true) {
			SendMail s = new SendMail();  
			try {
				s.sendEmail(3);
				Thread.sleep(2629800);
			}
			catch (InterruptedException e){
				e.printStackTrace();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
			
	}

}

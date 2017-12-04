package com.mercury.model.dao;

import java.sql.SQLException;
import java.util.Date;

public class InvioNewsLetterSett extends Thread implements Runnable{
	
	Date now;

	
	public InvioNewsLetterSett() {
		super();
	}
	
	public void run() {
		while(true) {
			SendMail s = new SendMail();
			try {
				s.sendEmail(2);
				Thread.sleep(604800);// secondi di una settimana
			}
			catch (InterruptedException e){
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}			
		}
	}
}

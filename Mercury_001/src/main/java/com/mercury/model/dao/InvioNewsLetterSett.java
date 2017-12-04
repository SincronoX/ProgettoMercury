package com.mercury.model.dao;

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
				Thread.sleep(604800);
			}
			catch (InterruptedException e){
				e.printStackTrace();
				
			}

			
		}
			
	}
	

}

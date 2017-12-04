package com.mercury.model.dao;

import java.util.Date;

public class InvioNewsLetterGio extends Thread implements Runnable{

	Date now;
	
	public InvioNewsLetterGio () {
		super();
	}
	
	public void run () {
		while (true) {
			SendMail s = new SendMail();
			s.SendMail(1);
			try {
				Thread.sleep(86400);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
			
	}
}

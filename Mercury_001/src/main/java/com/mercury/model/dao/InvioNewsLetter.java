package com.mercury.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.TimerTask;

public class InvioNewsLetter extends TimerTask {
	Date now;
	int idUtente;
	Connection conn = null;
	
	
	public InvioNewsLetter(int idUtente) {
		super();
		this.idUtente = idUtente;
	}


	public void run() {
		now = new Date();
		// Invio Email
		 
		
		if(conn==null) conn=DAO.getConnection();
        Statement st = conn.createStatement();
        
        ResultSet rs = st.executeQuery("SELECT * FROM mercury.utente where idUtente = "+idUtente);
        
        try {
            rs.first();
           	
            String mittente = "capo@hotmail.it";
           	String destinatario = rs.getString("emailUtente");
           	String oggetto = "i tuoi eventi";
           	String desc = "ciao";
           		
           	MailUtility.sendMail(destinatario, mittente, oggetto, desc);
        }
        catch (MessagingException exc){
	      exc.printStackTrace();

	    }
		
		
	}
}

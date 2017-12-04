package com.mercury.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {
	Connection conn = null;
	String host = "smtp.fastwebnet.it";
    String mittente = "mercury@gmail.com";
	 String oggetto = "";

	
	public void sendEmail(int cadenza) throws SQLException {
		
		if(conn==null) conn=DAO.getConnection();
        Statement st = conn.createStatement();
        
        Properties p = new Properties();
	    p.put("mail.smtp.host", host);
	    //p.put("port", 25); 
	     
	    Session sessione = Session.getDefaultInstance(p);
	     
	    MimeMessage mail = new MimeMessage(sessione);
	    

        String query="SELECT * FROM mercury.utente where idCadenza = " + cadenza;	

        // esegui query
        ResultSet rs = st.executeQuery(query);
		
		if(cadenza==1) { oggetto = "Invio newsLetter giornaliera Mercury"; }
		if(cadenza==2) { oggetto = "Invio newsLetter settimanale Mercury"; }
		if(cadenza==3) { oggetto = "Invio newsLetter mensile Mercury"; }
	
	    String testo = "Questi sono i possimi eventi scelti in base alle tue preferenze: \n\n";
	     
	    try {
	    	 while(rs.next()) {
	    		String dest = rs.getString("emailUtente");
	    		int idUtente = rs.getInt("idUtente");
	    		 
	    		String nuovaQuery = "select nomeEvento, dataInizio, dataFine, descrizione from utente u, preftipo p, eventoPrevisto e ";
	    		nuovaQuery += "where u.idUtente = p.idUtente and u.idUtente = "+idUtente+" and p.idTipoEvento = e.idTipoEvento";
	    		 
	            ResultSet rs2 = st.executeQuery(nuovaQuery);
	            String testoEventi = "";
	            while(rs2.next()) {
	            	String nomeEvento = rs2.getString("nomeEvento");
	            	String dataInizio = rs2.getString("dataInizio");
	            	String dataFine   = rs2.getString("dataFine");
	            	String desc       = rs2.getString("descrizione");
	            	
	            	testoEventi += ("- "+nomeEvento+" inzierà il: "+dataInizio+" e terminerà il: "+dataFine+" descrizione evento:"+desc+"\n");
	            }
	            testoEventi += "\nGrazie per aver scelto il servizio di newsletter di Mercury";
	            
	    	 	mail.setFrom(new InternetAddress(mittente));
	    	 	mail.addRecipients(Message.RecipientType.TO, dest);
	    	 	
	    	 	mail.setSubject(oggetto);
	    	 	mail.setText(testo+testoEventi);
	    	 	
	    	 	Transport.send(mail);
	    	 }	
	     }catch(Exception e) {
	    	 	e.printStackTrace();
	     }
	}
}

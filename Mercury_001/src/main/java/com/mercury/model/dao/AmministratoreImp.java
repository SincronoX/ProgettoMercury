package com.mercury.model.dao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import com.mercury.model.Ente;
import com.mercury.model.EventoPrevisto;


public class AmministratoreImp  implements AmministratoreUtil {
	
	
	
	public void InvioMailAbilitaEnte(Ente en) {
	
	String mitt = " mercury.sincronoX@gmail.com";
    String dest = en.getEmailEnte();
    String oggetto = "mail di conferma per accedere all'area riservata Ente al sito www.mercury.it";
    String testo1 = "l'admin ha confermato la registrazione dell'ente" +en.getNomeEnte() + " con id numero "+ en.getIdEnte() ;
    String testo2 = "  , puoi accedere al sito con le seguenti credenziali : ";
    String testo3 = " email : "+en.getEmailEnte()+ " password : "+ en.getPswEnte() ;
    String testo4 = "  . La avvertiamo che all'inserimento di eventi giudicati inopportuni ricevera' un email di cancellazione ";
String testo5 = "evento ed un avvertimento. dopo 3 avvertimenti il suo ente non potra' piu accedere nella propria area riservata "  ;
	}
  /*  try
    {
      MailUtility.sendMail(dest, mitt, oggetto, testo);

    }
    catch (MessagingException exc)
    {
				
	}
	*/

	public void checkEvento(EventoPrevisto ep, int idEnte) {
		// TODO Auto-generated method stub
		
	}

}

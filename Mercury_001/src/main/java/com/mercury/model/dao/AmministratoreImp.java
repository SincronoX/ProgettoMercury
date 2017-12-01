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
    String oggetto = "mail di conferma per accedere come ente a www.mercury.it";
    String testo = "l'admin ha confermato la tua registrazione, puoi accedere al sito con";
    
				
	}
	
/*

    String mitt = request.getParameter("mittente");
    String dest = request.getParameter("destinatario");
    String oggetto = request.getParameter("oggetto");
    String testo = request.getParameter("contenuto");

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    try
    {
      MailUtility.sendMail(dest, mitt, oggetto, testo);
      out.println("Invio messaggio OK!");
    }
    catch (MessagingException exc)
    {
      out.println("Invio non riuscito!");
      log("MessagingException: " + dest);
      log(exc.toString());
    }
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException
  {
    this.doPost(request, response);
  }
}
	 * 
	 * 
	 * */





	public void checkEvento(EventoPrevisto ep, int idEnte) {
		// TODO Auto-generated method stub
		
	}

}

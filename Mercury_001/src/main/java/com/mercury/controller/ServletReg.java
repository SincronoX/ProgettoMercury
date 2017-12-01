package com.mercury.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mercury.model.Ente;
import com.mercury.model.dao.EnteImp;

public class ServletReg extends HttpServlet {
	private static final long serialVersionUID = 1L;
      	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher disp;
		 Ente ente ;
		 
		 if(request.getParameter("form").equals("registrazioneEnte")) //campo hidden di RegistrazioneEnte.jsp
		{	String messaggio=null;
			EnteImp ei = new EnteImp();
			ente=new Ente();
			ente.setNomeEnte(request.getParameter("nomeEnte"));
			ente.setEmailEnte(request.getParameter("emailEnte"));
			boolean trovato = ei.trovaEnte(ente);
			if(trovato==true)
			{	
				messaggio = " Impossibile registrarti, il nome o l'email sono gia' presenti nel database";
				disp=request.getRequestDispatcher("view/RegistrazioneEnte.jsp");	
				request.setAttribute("giaEsiste", messaggio);
				disp.forward(request, response);
			} 
			else 
			{
				messaggio= "richiesta di registrazione effettuata, attendi email di conferma"; // alert!!
				ei.addEnte(ente);
				disp=request.getRequestDispatcher("HomePage.jsp");	
				request.setAttribute("inAttesa", messaggio);
				disp.forward(request, response);
			}
		
	}

}
}


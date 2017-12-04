package com.mercury.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mercury.model.Ente;
import com.mercury.model.Utente;
import com.mercury.model.dao.EnteImp;
import com.mercury.model.dao.UtenteImp;


public class ServletMail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher disp;
		 Utente u ;
		 
		 if(request.getParameter("form").equals("registrazioneUtente")) //campo hidden di RegistrazioneEnte.jsp
		{	
			String messaggio=null;
			UtenteImp ui = new UtenteImp();
			u=new Utente();
			u.setEmailUtente(request.getParameter("emailUtente"));	
			u.setIdCadenza(Integer.parseInt(request.getParameter("idCadenza")));
			u.setIdComune(request.getParameter("idComune"));
			
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

//String emailUtente, int idCadenza, String idComune, ArrayList<Integer> preferenze
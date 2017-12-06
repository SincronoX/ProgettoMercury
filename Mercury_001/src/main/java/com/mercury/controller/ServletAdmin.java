package com.mercury.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mercury.model.Amministratore;
import com.mercury.model.Ente;
import com.mercury.model.EventoPrevisto;
import com.mercury.model.dao.AmministratoreImp;
import com.mercury.model.dao.EnteImp;
import com.mercury.model.dao.MercuryImp;


public class ServletAdmin extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		RequestDispatcher disp;
		Ente ente ;
		HttpSession ss=request.getSession();
		MercuryImp m = new MercuryImp(); 
		EnteImp ei = new EnteImp();
		AmministratoreImp ai = new AmministratoreImp();
		
		int numEnte = Integer.parseInt(request.getParameter("enteInAtt"));
		System.out.println(numEnte);
		int numEv = Integer.parseInt(request.getParameter("numEv"));
		String chedevoFare = request.getParameter("enteOK"); //accetta , rifiuta
		String chedevoFare1 = request.getParameter("checkOK"); //accetta , ban
		String messaggio = null;
		EventoPrevisto ep = new EventoPrevisto();
		if(chedevoFare.equals("Accetta")) {
			ente=(Ente)ss.getAttribute("enteInAttesa0");//+numEnte);
			System.out.println("accetta"+ente.getNomeEnte());
			ai.InvioMailAbilitaEnte(ente);
			messaggio="ente accettato";
			
		}
		else if(chedevoFare.equals("Rifiuta")) 
		{
			//System.out.println("rifiuta"+((Ente)ss.getAttribute("enteInAttesa"+numEvento)).getNomeEnte());
			
			ente=(Ente)ss.getAttribute("enteInAttesa"+numEnte);
			ente.setEmailEnte("dorianshurdhi@hotmail.it");
			ai.InvioMailDeclinaEnte(ente);
			messaggio="ente rifiutato";
		}
		else if(chedevoFare1.equals("Accetta")) //evento ok
		{
			ep.setCheck(true);
			messaggio="evento controllato";
		}
		else if(chedevoFare1.equals("Ban")) //bane evento
		{
			ep=(EventoPrevisto)ss.getAttribute("evento"+numEv);
			ep.setCheck(true);
			ente = ei.getEnteById(ep.getIdEnte());
			ai.mailBanEvento(ente);
		}
		
		disp=request.getRequestDispatcher("view/AreaRiservataAdmin.jsp");	
		disp.forward(request, response);
	}
}


/*

			ente.setEmailEnte(request.getParameter("emailEnte"));
			ei.trovaEnte(ente);
			if(trovato==true)
			{	
				String messaggio = " Impossibile registrarti, il nome o l'email sono gia' presenti nel database";
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
			}*/

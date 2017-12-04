package com.mercury.controller;

import java.io.IOException;
import java.sql.SQLException;
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


			boolean trovato = ui.trovaUtente(u.getEmailUtente());
			if(trovato==true)
			{	
				u.setIdCadenza(Integer.parseInt(request.getParameter("idCadenza")));
				u.setIdComune(request.getParameter("idComune"));
				messaggio = " Impossibile registrarti alla newsletter, l'email e' gia' presenti nel database";
				disp=request.getRequestDispatcher("view/registrazioneUtente.jsp");	
				request.setAttribute("giaEsiste", messaggio);
				disp.forward(request, response);
			} 
			else 
			{
				messaggio= "registrazione effettuata"; // alert!!
				ArrayList <Integer> lista = new ArrayList<Integer>();		
				for(int i = 0 ; i<lista.size() ; i++) 
				{
					lista.add(Integer.parseInt(request.getParameter("idPreferenza"+i)));
				}
				try 
				{
					ui.addUtente(u.getEmailUtente(), u.getIdCadenza(), u.getIdComune(), lista);
					disp=request.getRequestDispatcher("HomePage.jsp");	
					request.setAttribute("inserito", messaggio);
					disp.forward(request, response);
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}

			}

		}

	}
}

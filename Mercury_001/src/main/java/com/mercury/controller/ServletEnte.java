package com.mercury.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mercury.model.Utente;
import com.mercury.model.Amministratore;
import com.mercury.model.Ente;
import com.mercury.model.EventoPrevisto;
import com.mercury.model.dao.AmministratoreImp;
import com.mercury.model.dao.EnteImp;

/**
 * Servlet implementation class ServletEnte
 */
public class ServletEnte extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public ServletEnte() {
		super(); 
	}
   

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=null;
		String tipoForm = request.getParameter("modEv");
		String newEvento = request.getParameter("nuovoEvento");
		RequestDispatcher req=null;
		try{	    

			
			EnteImp enteimp = new EnteImp();
			
			if(tipoForm.equals("Aggiungi")) {
				String email = request.getParameter("email");
				Ente e = new Ente();
				e = enteimp.getEnteByEmail(email);
				request.setAttribute("ente", e);
				req=request.getRequestDispatcher("view/InserisciEvento.jsp");
				req.forward(request, response);
			}
			else if(tipoForm.equals("Modifica"))
			{
				EventoPrevisto ep = new EventoPrevisto();
				int numEvento =  Integer.parseInt(request.getParameter("numEv"));
				ep = (EventoPrevisto) request.getAttribute("evento"+numEvento);
				enteimp.modificaEvento(ep);
				req=request.getRequestDispatcher("view/AreaRiservataEnte.jsp");
				req.forward(request, response);
			}
			else if(tipoForm.equals("Elimina"))
			{
				EventoPrevisto ep = new EventoPrevisto();
				int numEvento =  Integer.parseInt(request.getParameter("numEv"));
				ep = (EventoPrevisto) request.getAttribute("evento"+numEvento);
				enteimp.eliminaEvento(ep);
				req=request.getRequestDispatcher("view/AreaRiservataEnte.jsp");				
				req.forward(request, response);
			}
			else if(newEvento.equals("Inserisci")) {
				String idEnte= request.getParameter("idEnte");
				EventoPrevisto e = (EventoPrevisto) request.getAttribute("evento");
				enteimp.inserisciEvento(e,idEnte);
				req=request.getRequestDispatcher("view/AreaRiservataEnte.jsp");
				req.forward(request, response);				
			}
		} 
		


		catch (Throwable theException){

			System.out.println(theException); 
		}
	}
}



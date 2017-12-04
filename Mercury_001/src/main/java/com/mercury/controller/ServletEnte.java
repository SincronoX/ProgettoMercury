package com.mercury.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.corso.model.Utente;
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
		RequestDispatcher req=null;
		try{	    

			Ente ente = new Ente();
			EnteImp enteimp = new EnteImp();
			
			if(tipoForm.equals("Aggiungi")) {
				Ente e = new Ente();
				e = (Ente)request.getAttribute("ente");
				request.setAttribute("ente", ente);
				req=request.getRequestDispatcher("view/InserisciEvento.jsp");
				req.forward(request, response);
			}
			else if(tipoForm.equals("Modifica"))
			{
				out=response.getWriter();
				EventoPrevisto ep = new EventoPrevisto();
				int numEvento =  Integer.parseInt(request.getParameter("numEv"));
				ep = (EventoPrevisto) request.getAttribute("evento"+numEvento);
				enteimp.modificaEvento(ep);
				req=request.getRequestDispatcher("view/AreaRiservataEnte.jsp");
				req.forward(request, response);
			}
			else if(tipoForm.equals("Elimina"))
			{
				out=response.getWriter();
				EventoPrevisto ep = new EventoPrevisto();
				int numEvento =  Integer.parseInt(request.getParameter("numEv"));
				ep = (EventoPrevisto) request.getAttribute("evento"+numEvento);
				enteimp.eliminaEvento(ep);
				req=request.getRequestDispatcher("view/AreaRiservataEnte.jsp");				
				req.forward(request, response);
			}
		} 
		


		catch (Throwable theException){

			System.out.println(theException); 
		}
	}
}



package com.mercury.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
		String tipoForm = request.getParameter("submit");
		RequestDispatcher req=null;
		try{	    

			Ente ente = new Ente();
			EnteImp enteimp = new EnteImp();
			ente.setEmailEnte(request.getParameter("emailEnte"));
			ente.setPswEnte(request.getParameter("pswEnte"));
			

		
			
			if(tipoForm.equals("Inserisci nuovo evento")) {
				out=response.getWriter();
				EventoPrevisto ep = new EventoPrevisto();
				ep = (EventoPrevisto) request.getAttribute("evento"); //session
				enteimp.inserisciEvento(ep);
				req=request.getRequestDispatcher("view/AreaRiservataEnte.jsp");
				req.forward(request, response);
			}
			else if(tipoForm.equals("Modifica Evento"))
			{
				out=response.getWriter();
				EventoPrevisto ep = new EventoPrevisto();
				ep = (EventoPrevisto) request.getAttribute("evento");//session
				enteimp.modificaEvento(ep);
				req=request.getRequestDispatcher("view/AreaRiservataEnte.jsp");
				req.forward(request, response);
			}
			else if(tipoForm.equals("Elimina Evento"))
			{
				out=response.getWriter();
				EventoPrevisto ep = new EventoPrevisto();
				ep = (EventoPrevisto) request.getAttribute("evento");//session
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



package com.mercury.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mercury.model.Amministratore;
import com.mercury.model.Ente;
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
		
		try{	    

			Ente ente = new Ente();
			ente.setEmailEnte(request.getParameter("emailEnte"));
			ente.setPswEnte(request.getParameter("pswEnte"));
			

			boolean esisteEnte = EnteImp.controlloLoginEnte(ente.getEmailEnte(),ente.getPswEnte());

			if (esisteEnte) {

				HttpSession session = request.getSession(true);	    
				session.setAttribute("currentSessionUser",ente); 
				response.sendRedirect("AreaRiservataEnte.jsp"); //logged-in page      		
			}

			else 
				response.sendRedirect("Errore.jsp"); //error page 
		} 


		catch (Throwable theException){

			System.out.println(theException); 
		}
	}
}



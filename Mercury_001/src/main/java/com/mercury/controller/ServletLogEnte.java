package com.mercury.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mercury.model.Ente;
import com.mercury.model.dao.EnteImp;

/**
 * Servlet implementation class ServletLogEnte
 */
public class ServletLogEnte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagina = request.getParameter("submit");
		Ente ente = new Ente();
		EnteImp enteimp = new EnteImp();
		if(pagina.equals("login")) {
		boolean esisteEnte = enteimp.controlloLoginEnte(ente.getEmailEnte(),ente.getPswEnte());
		if (esisteEnte) {

			HttpSession session = request.getSession(true);	    
			session.setAttribute("currentSessionUser",ente); 
			response.sendRedirect("AreaRiservataEnte.jsp"); //logged-in page      		
		}

		else 
			response.sendRedirect("Errore.jsp"); //error page
		}
		if(pagina.equals("logout")) {
			 HttpSession session = request.getSession(false);

		        if(session!=null){

		            session.invalidate();
		            session=null;
		        }
		        request.getRequestDispatcher("HomePage.jsp").forward(request,response);
		}
		doGet(request, response);
	}

}



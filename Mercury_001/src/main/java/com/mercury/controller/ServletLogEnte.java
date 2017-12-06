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

/**
 * Servlet implementation class ServletLogEnte
 */
public class ServletLogEnte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String pagina = request.getParameter("log");
		RequestDispatcher req=null;
		Ente ente = new Ente();
		String email = request.getParameter("emailEnte");
		String psw = request.getParameter("pswEnte");
		EnteImp enteimp = new EnteImp();
		if(pagina.equals("login")) {
		boolean esisteEnte = enteimp.controlloLoginEnte(email, psw);
		if (esisteEnte) {

			/*HttpSession session = request.getSession(true);	    
			session.setAttribute("currentSessionUser",ente); */
			ente = enteimp.getEnteByEmail(email);

			HttpSession session = request.getSession(true);	    
			session.setAttribute("currentSessionUser",ente); 


			req=request.getRequestDispatcher("view/AreaRiservataEnte.jsp");	
			request.setAttribute("ente", ente);
			req.forward(request, response);      		
			
		}

		else 
			response.sendRedirect("view/LoginEnte.jsp"); 
		}
		if(pagina.equals("Logout")) {
			 HttpSession session = request.getSession(false);

		        if(session!=null){

		            session.invalidate();
		            session=null;
		        }
		        request.getRequestDispatcher("HomePage.jsp").forward(request,response);
		}
	}

}
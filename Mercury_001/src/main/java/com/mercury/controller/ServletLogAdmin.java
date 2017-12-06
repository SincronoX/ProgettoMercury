package com.mercury.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mercury.model.Amministratore;
import com.mercury.model.dao.AmministratoreImp;


public class ServletLogAdmin extends HttpServlet
{

	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		//HttpSession session = request.getSession(true);
		RequestDispatcher rd = null;
		Amministratore admin = new Amministratore();

		if(request.getParameter("form").equals("LoginAdmin")) {		 //campo hidden di LoginAdmin.jsp
			
			AmministratoreImp ai = new AmministratoreImp();
			String email =request.getParameter("emailAdmin");
			String pass =request.getParameter("pswAdmin");
			//admin.setEmailAdmin(email);
			//admin.setPswAdmin(pass);
			boolean	esisteAdmin= ai.trovaAdmin(email, pass);

			if(esisteAdmin==true) {	
				
				

				// metto i valori nella sessione
				HttpSession session = request.getSession();
				session.setAttribute("admin", admin);
				
				// inoltro 
				ServletContext application  = getServletContext();
				RequestDispatcher rd1 = application.getRequestDispatcher("/view/AreaRiservataAdmin.jsp");
				rd1.forward(request, response);
				//return; 
				
//				session=request.getSession(true);	    
//				session.setAttribute("sessioneAmm", admin); 
//				//response.sendRedirect("view/AreaRiservataAdmin.jsp");
//				rd = request.getRequestDispatcher("view/AreaRiservataAdmin.jsp");
//				//request.setAttribute("Amm", admin);
//				rd.forward(request, response); 
			} 
			else {

				rd = request.getRequestDispatcher("view/LoginAdmin.jsp");
				String messaggioErrore = "login errato" ;
				request.setAttribute("errore", messaggioErrore);
				rd.forward(request, response); 
				//		response.sendRedirect("view/LoginAdmin.jsp");
			}
		}
//		else if (request.getParameter("form").equals("LogOut")) 
//		{	 admin = null;
//			session.setAttribute("sessioneAmm", admin); 
//			session = request.getSession(false);
//			if (session != null) 
//			{
//				session.invalidate();
//				session=null;
//			}
//			rd = request.getRequestDispatcher("view/HomePage.jsp");
//			rd.forward(request, response); 
//		}


	}




}






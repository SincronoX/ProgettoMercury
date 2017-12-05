package com.mercury.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mercury.model.Amministratore;
import com.mercury.model.dao.AmministratoreImp;

public class ServletLogAdmin extends HttpServlet{
	
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try{	    

			Amministratore admin = new Amministratore();
			admin.setEmailAdmin(request.getParameter("email"));
			admin.setPswAdmin(request.getParameter("password"));
			
			//String emailAdmin = admin.getEmailAdmin();
			//String pswAdmin = admin.getPswAdmin();
			AmministratoreImp ai = new AmministratoreImp();
			boolean esisteAdmin = ai.trovaAdmin(admin.getEmailAdmin(),admin.getPswAdmin());

			if (esisteAdmin==true) {

				HttpSession session = request.getSession(true);	    
				session.setAttribute("currentSessionUser",admin); 
				response.sendRedirect("view/AreaRiservataAdmin.jsp"); //logged-in page , mando l'admin nella sua area riservata.     		
			}

			else 
				response.sendRedirect("Errore.jsp"); //error page , amministratore non registrato!
		} 

		catch (Throwable theException){

			System.out.println(theException); 
		}
	}
	

}

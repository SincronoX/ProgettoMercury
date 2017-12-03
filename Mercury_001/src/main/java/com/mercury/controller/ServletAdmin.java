package com.mercury.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mercury.model.Amministratore;

/**
 * Servlet implementation class ServletAdmin
 */
public class ServletAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ServletAdmin() {
        super();
    }
    
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		try
		{	    

		     Amministratore admin = new Amministratore();
		     admin.setEmailAdmin(request.getParameter("email"));
		     admin.setPswAdmin(request.getParameter("password"));

		     admin = adminDAO.login(user);
			   		    
		     if (user.isValid())
		     {
			        
		          HttpSession session = request.getSession(true);	    
		          session.setAttribute("currentSessionUser",admin); 
		          response.sendRedirect("AreaRiservataAdmin.jsp"); //logged-in page      		
		     }
			        
		     else 
		          response.sendRedirect("invalidLogin.jsp"); //error page 
		} 
				
				
		catch (Throwable theException) 	    
		{
		     System.out.println(theException); 
		}
		       }
	}



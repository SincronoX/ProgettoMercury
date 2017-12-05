<<<<<<< HEAD
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
import com.mercury.model.dao.AmministratoreImp;

/**
 * Servlet implementation class ServletAdmin
 */
public class ServletLogAdmin extends HttpServlet {

	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{



		if(request.getParameter("form").equals("LoginAdmin")) {		 //campo hidden di LoginAdmin.jsp

			PrintWriter out = response.getWriter();  
			Amministratore admin = new Amministratore();
			AmministratoreImp ai = new AmministratoreImp();
			boolean	esisteAdmin= ai.trovaAdmin(request.getParameter("emailAdmin"), request.getParameter("pswAdmin"));


			if(esisteAdmin==true) {			
				admin.setEmailAdmin(request.getParameter("emailAdmin"));
				admin.setPswAdmin(request.getParameter("pswAdmin"));

				HttpSession session = request.getSession(true);	    
				session.setAttribute("currentSessionUser",admin); 
				response.sendRedirect("view/AreaRiservataAdmin.jsp");

				out.print("Hello, "+admin+" Welcome to Profile");

			} 
			else {

				String error="Invalid Login";
				request.setAttribute("error",error);
				response.sendRedirect("view/LoginAdmin.jsp");

			}
		}

	
		 /* if(request.getParameter("form").equals("Logout")) {
			HttpSession session = request.getSession(false);

			if(session!=null){

				session.invalidate();
				session=null;
			}
			request.getRequestDispatcher("HomePage.jsp").forward(request,response);
		}
		doGet(request, response); */


	}
}



=======
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
>>>>>>> 6568a1cbabfe2f1fff25f4d30f1e622b3195a447

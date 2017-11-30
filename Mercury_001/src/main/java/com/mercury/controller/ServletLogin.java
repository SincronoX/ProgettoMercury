package com.mercury.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletLogin extends HttpServlet {  
	public void doPost(HttpServletRequest request, HttpServletResponse response)  
	        throws ServletException, IOException {
	
	 response.setContentType("LoginEnte/jsp");  
	    PrintWriter out = response.getWriter();  
	          
	    String email=request.getParameter("email");  
	    String password=request.getParameter("password");  
	          
	   if(LoginDao.validate(email, password)){  
	        RequestDispatcher rd=request.getRequestDispatcher("servletEnte");  
	        rd.forward(request,response);  
	    }  
	    else{  
	        out.print("Sorry username or password error");  
	        RequestDispatcher rd=request.getRequestDispatcher("RegistrazioneEnte.jsp");  
	        rd.include(request,response);  
	    }  
	          
	    out.close();  
	    }  
	
	

}

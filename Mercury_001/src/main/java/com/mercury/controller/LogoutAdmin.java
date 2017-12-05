package com.mercury.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletLogoutAdmin
 */


public class LogoutAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
			HttpSession session = request.getSession(false);

			if(session!=null){

				session.invalidate();
				session=null;
			}
			request.getRequestDispatcher("view/HomePage.jsp").forward(request,response);
		
		doPost(request, response);
	}
}


package com.mercury.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.mercury.model.Ente;
import com.mercury.model.EventoPrevisto;


public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		HttpSession s=request.getSession();
		EventoPrevisto ev = (EventoPrevisto)s.getAttribute("evento");
		//EventoPrevisto ev = (EventoPrevisto)request.getAttribute("evento");
		
		Ente eia = (Ente)s.getAttribute("enteInAttesa");
		
		out.print(ev.getNomeEvento());
		out.print(eia.getEmailEnte());
		
		
		
			
		}
		
		
		
		
	}



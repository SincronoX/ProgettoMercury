// Fabio Savelli

package com.mercury.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mercury.model.dao.EventoInPassato;
import com.mercury.model.dao.InvioNewsLetterGio;
import com.mercury.model.dao.InvioNewsLetterMens;
import com.mercury.model.dao.InvioNewsLetterSett;

/**
 * Servlet implementation class ServletStart
 */
public class ServletStart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		EventoInPassato eve = new EventoInPassato();
		eve.start();
		
		InvioNewsLetterGio gio   = new InvioNewsLetterGio();
		gio.start();
		  
		InvioNewsLetterSett sett = new InvioNewsLetterSett();
		sett.start();
		  
		InvioNewsLetterMens mens = new InvioNewsLetterMens();
		mens.start(); 

		RequestDispatcher disp=request.getRequestDispatcher("/index.jsp");
		disp.forward(request,response);
		
	}

}

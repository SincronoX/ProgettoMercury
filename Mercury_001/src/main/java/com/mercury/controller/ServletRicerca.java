// Fabio Savelli

package com.mercury.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mercury.model.EventoPrevisto;
import com.mercury.model.Luogo;
import com.mercury.model.TipoEvento;
import com.mercury.model.dao.MercuryImp;

/**
 * Servlet implementation class ServletRicerca
 */
public class ServletRicerca extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Luogo l = new Luogo();
		Calendar d = null;
		ArrayList<TipoEvento> t = new ArrayList<TipoEvento>();
		
		MercuryImp m = new MercuryImp();
		ArrayList<EventoPrevisto> ret = new ArrayList<EventoPrevisto>();
		
		try {
			ret = m.getRicerca(t, l, d);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher disp=request.getRequestDispatcher("/scheda_utente.jsp");
		request.setAttribute("risultatoRicerca", ret);
		disp.forward(request,response);
		
	}

}

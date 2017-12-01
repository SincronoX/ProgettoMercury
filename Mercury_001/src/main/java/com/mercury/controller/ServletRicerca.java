// Fabio Savelli

package com.mercury.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mercury.model.EventoPrevisto;
import com.mercury.model.TipoEvento;
import com.mercury.model.dao.ComuneImp;
import com.mercury.model.dao.MercuryImp;
import com.mercury.model.dao.TipoEventoImp;

/**
 * Servlet implementation class ServletRicerca
 */
public class ServletRicerca extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	private Calendar stringToData(String s) {
		String[] aux = s.split("-");
		int anno = Integer.parseInt(aux[0]);
		int mese = Integer.parseInt(aux[1]); 
		int giorno = Integer.parseInt(aux[2]);
		Calendar ret = new GregorianCalendar(anno, mese, giorno);
		return ret;
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		MercuryImp m = new MercuryImp();
		
		TipoEvento att = new TipoEvento();
		TipoEventoImp tipi = new TipoEventoImp();
		ArrayList<TipoEvento> t = tipi.getEventoCatAll();
		if(request.getParameter("tipo1") == null) {
			att = tipi.getTipoById(1);
			t.remove(att);
		}
		if(request.getParameter("tipo2") == null) {
			att = tipi.getTipoById(2);
			t.remove(att);
		} 
		if(request.getParameter("tipo3") == null) {
			att = tipi.getTipoById(3);
			t.remove(att);
		}
		if(request.getParameter("tipo4") == null) {
			att = tipi.getTipoById(4);
			t.remove(att);
		}
		
		String comune = 	request.getParameter("comune");
		String provincia = 	request.getParameter("provincia");
		String regione =	request.getParameter("regione");
		
		ComuneImp comImp= new ComuneImp();
		String idComune = comImp.getIdComune(regione, provincia, comune);
		
		String data = request.getParameter("data");
		Calendar d = stringToData(data);
		
		ArrayList<EventoPrevisto> ret = new ArrayList<EventoPrevisto>();
		
		try {
			ret = m.getRicerca(t, idComune, d);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher disp=request.getRequestDispatcher("/RisultatoRicerca.jsp");
		request.setAttribute("risultatoRicerca", ret);
		disp.forward(request,response);
		
	}

}

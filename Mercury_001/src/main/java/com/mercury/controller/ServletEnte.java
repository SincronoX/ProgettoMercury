package com.mercury.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mercury.model.Utente;
import com.mercury.model.Amministratore;
import com.mercury.model.Ente;
import com.mercury.model.EventoPrevisto;
import com.mercury.model.dao.AmministratoreImp;
import com.mercury.model.dao.EnteImp;

/**
 * Servlet implementation class ServletEnte
 */
public class ServletEnte extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public ServletEnte() {
		super(); 
	}
   
	public Calendar stringToDate(String s) {
		String[] aux = s.split("-");
		int anno = Integer.parseInt(aux[0]);
		int mese = Integer.parseInt(aux[1]) - 1; 
		int giorno = Integer.parseInt(aux[2]);
		Calendar ret = new GregorianCalendar(anno, mese, giorno);
		return ret;
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("asdbfbasdfbasdfbasdfasdjkbfhkasdbfbhk");

		String tipoForm = request.getParameter("modEv");
		RequestDispatcher req=null;
		try{	    

			
			EnteImp enteimp = new EnteImp();
			
			if(tipoForm.equals("Aggiungi")) {
				String email = request.getParameter("email");
				Ente e = new Ente();
				e = enteimp.getEnteByEmail(email);
				req=request.getRequestDispatcher("view/InserisciEvento.jsp");
				request.setAttribute("ente", e);
				req.forward(request, response);
			}
			
			if(tipoForm.equals("Modifica"))
			{
				EventoPrevisto ep = new EventoPrevisto();
				int numEvento =  Integer.parseInt(request.getParameter("numEv"));
				ep = (EventoPrevisto) request.getAttribute("evento"+numEvento);
				enteimp.modificaEvento(ep);
				req=request.getRequestDispatcher("view/AreaRiservataEnte.jsp");
				req.forward(request, response);
			}
			
			if(tipoForm.equals("Elimina"))
			{
				
				String email = request.getParameter("email");
				Ente e = new Ente();
				e = enteimp.getEnteByEmail(email);
				EventoPrevisto ep = new EventoPrevisto();
				
				
				int numEvento =  Integer.parseInt(request.getParameter("numEv"));
				System.out.println(numEvento);
				HttpSession session = request.getSession(true);

				ep = (EventoPrevisto)session.getAttribute("eventi"+numEvento); 
				System.out.println(ep.getNomeEvento());

				enteimp.eliminaEvento(ep);
				response.sendRedirect("view/AreaRiservataEnte.jsp");
				/*ep = (EventoPrevisto) request.getAttribute("eventi"+numEvento);
				System.out.println(ep);*/
			
				
				
				

				/*req=request.getRequestDispatcher("view/AreaRiservataEnte.jsp");	
				request.setAttribute("ente", e);
				req.forward(request, response);*/
			}
			
			if(tipoForm.equals("Inserisci")) {

				String emailEnte= request.getParameter("erica");
				EventoPrevisto e = new EventoPrevisto(); 
				Ente ente = enteimp.getEnteByEmail(emailEnte);

				
				Calendar dInizio = stringToDate(request.getParameter("dataInizio"));
				Calendar dFine   = stringToDate(request.getParameter("dataFine"));
								
				e.setNomeEvento(request.getParameter("nomeEvento"));
				e.setDescEvento(request.getParameter("descEvento"));
				e.setDataInizio(dInizio);	
				e.setDataFine(dFine);
				e.setIdTipoEvento(Integer.parseInt(request.getParameter("tipoEvento")));
				e.setIdComune(request.getParameter("idComune"));
				e.setCheck(false);
				e.setIdEnte(ente.getIdEnte());
				 
				enteimp.inserisciEvento(e, enteimp.getEnteByEmail(emailEnte).getIdEnte());
				
				//HttpSession session = request.getSession(true);
				//session.setAttribute("ente", enteimp.getEnteById(Integer.parseInt(idEnte))); 
				//response.sendRedirect("view/AreaRiservataEnte.jsp");
				
				req=request.getRequestDispatcher("view/AreaRiservataEnte.jsp");
				request.setAttribute("ente", ente);
				req.forward(request, response);	
				
				/*
				request.setAttribute("ente", enteimp.getEnteById(Integer.parseInt(idEnte)));
				req=request.getRequestDispatcher("view/AreaRiservataEnte.jsp");
				
				req.forward(request, response);					
				*/
			}
			
			if(tipoForm.equals("Edita")) {		
				int numEvento = Integer.parseInt(request.getParameter("numEv"));
				EventoPrevisto e = (EventoPrevisto) request.getAttribute("evento"+numEvento);
				enteimp.modificaEvento(e);
				req=request.getRequestDispatcher("view/AreaRiservataEnte.jsp");
				req.forward(request, response);				
			}
		} 
		


		catch (Throwable theException){

			System.out.println(theException); 
		}
	}
}



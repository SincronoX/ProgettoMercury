package com.mercury.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.*;
import com.mercury.model.Comune;
import com.mercury.model.Provincia;
import com.mercury.model.dao.ComuneImp;
import com.mercury.model.dao.ProvinciaImp;


public class ServletLuogo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id= request.getParameter("idRegione");
		if(id!=null)
		{
		ProvinciaImp pi=new ProvinciaImp();
		ArrayList<Provincia> list=new ArrayList<Provincia>();
		try {
			list = pi.getProvinceByRegione(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String json=null;
	
		json=new Gson().toJson(list);
		
		
		response.setContentType("application/json");
		response.getWriter().write(json);
		}
		else
		{
			id= request.getParameter("idProvincia");
			ComuneImp pi=new ComuneImp();
			ArrayList<Comune> list=new ArrayList<Comune>();
			try {
				list = pi.getComuniByProvincia(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String json=null;
		
			json=new Gson().toJson(list);
			
			
			response.setContentType("application/json");
			response.getWriter().write(json);
			
			
		}

	}

}

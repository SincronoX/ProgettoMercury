package com.mercury.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mercury.model.Provincia;

public class ProvinciaImp implements ProvinciaUtil{
	
	Connection conn = null;
	
	public Provincia getProvinciaById(String id) throws SQLException 
	{
		if (conn==null)
		{
			conn=DAO.getConnection();  
		}
		
		Provincia x = new Provincia ();
		
		Statement st = conn.createStatement();
		
		ResultSet rs = st.executeQuery("select * from mercury.provincia p where p.idProvincia ='"+id+"'");
		
		try 
		{
			rs.first();
			String nome = rs.getString("nomeProvincia");
			x.setNomeProvincia(nome);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return x;
	}

	
	
	
	public ArrayList<Provincia> getProvinceByRegione(String id) throws SQLException
	{
		if (conn==null)
		{
			conn=DAO.getConnection();
		}
		
		Statement st = conn.createStatement();
		
		ResultSet rs = st.executeQuery("select * from mercury.provincia p where p.idRegione = "+id );
		
		ArrayList<Provincia> list = new ArrayList<Provincia>();
		Provincia x = null;
		
		try 
		{
			while (rs.next())
			{				
				x = new Provincia();
				x.setIdProvincia(rs.getString("idProvincia"));
				x.setNomeProvincia(rs.getString("nomeProvincia"));
				list.add(x);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return list;
	}
}

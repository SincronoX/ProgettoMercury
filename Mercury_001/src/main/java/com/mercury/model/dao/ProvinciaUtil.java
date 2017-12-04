package com.mercury.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.mercury.model.Provincia;

public interface ProvinciaUtil {
	
	public Provincia getProvinciaById(String id) throws SQLException;
	
	public ArrayList<Provincia> getProvinceByRegione(String id) throws SQLException;
	
}

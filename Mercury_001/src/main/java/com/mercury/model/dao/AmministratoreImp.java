package com.mercury.model.dao;

import com.mercury.model.Ente;
import com.mercury.model.EventoPrevisto;
import com.mysql.jdbc.Connection;

public class AmministratoreImp implements AmministratoreUtil {
	
Connection conn=null;
	
	public AmministratoreImp() {
		super();
		conn=DAO.getConnection();
	}
	
	public int getId(String email, String password) throws SQLException{
        if(conn==null) conn=DAO.getConnection();
        Statement st = conn.createStatement();
        int id=0;
        
        ResultSet rs = st.executeQuery("select idAdmin from amministratore where emailAdmin='"+email+"' and pswAdmin='"+password+"'");
        
        if(!rs.first()) {
        	return -1;
        }
        id=Integer.parseInt(rs.getString("idAdmin"));
        return id;
    }
	
	public String getEmailAdmin(int idAdmin) throws SQLException{
        if(conn==null) conn=DAO.getConnection();
        Statement st = conn.createStatement();
        String email = "";
        
        ResultSet rs = st.executeQuery("select emailAdmin from amministratore where idAdmin="+idAdmin);
        try {
        	rs.first();
        	user=rs.getString("email");
        }catch(SQLException e) {
        	return "";
        }
        return email;
    }
	
	public void abilitaEnte(String email, String nome) {
		
	}
	
	public void confermaMail() {
		
	}
	
	public void checkEvento(EventoPrevisto ep, Ente en) {
		
	}
	
	

}

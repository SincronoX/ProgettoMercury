package com.mercury.model.dao;
import com.mercury.model.dao.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;

import com.mercury.model.Amministratore;
import com.mercury.model.Ente;
import com.mercury.model.EventoPrevisto;


public class AmministratoreImp  implements AmministratoreUtil {
	
	protected String mitt = " mercury.sincronoX@gmail.com";
	
	
	public boolean trovaAdmin(String email , String psw){
		Connection conn = DAO.getConnection();		
		String query="select * from amministratore a where a.emailAdmin = "+email+ " and a.pswAdmin = "+psw ;
		ResultSet rs;
		Amministratore am = new Amministratore();
		try {
			rs = DAO.execute_Query(conn, query );
			if(rs.first()==true) 
			{ return true ;}	
		}catch(SQLException e) {}
		return false ;
	}
	
	public void InvioMailAbilitaEnte(Ente en) {
	
	
    String dest = en.getEmailEnte();
    String oggetto = "mail di conferma per accedere all'area riservata Ente al sito www.mercury.it";
    String testo1 = "l'admin ha confermato la registrazione dell'ente" +en.getNomeEnte() + " con id numero "+ en.getIdEnte() ;
    String testo2 = "  , puoi accedere al sito con le seguenti credenziali : ";
    String testo3 = " email : "+en.getEmailEnte()+ " password : "+ en.getPswEnte() ;
    String testo4 = "  . La avvertiamo che all'inserimento di eventi giudicati inopportuni ricevera' un email di cancellazione ";
    String testo5 = "evento ed un avvertimento. dopo 3 avvertimenti il suo ente non potra' piu accedere nella propria area riservata "  ;
    String testo = testo1+testo2+testo3+testo4 ;

	}
  /*  try
    {
      MailUtility.sendMail(dest, mitt, oggetto, testo);

    }
    catch (MessagingException exc)
    {
				
	}
}

	
	*/

	public void checkEvento(EventoPrevisto ep,  boolean ok) {
		ep.setCheck(true);
		if(ok==false) //se l'evento va bene niente, altrimenti entra nell'if
		{
			 int idEnte = ep.getIdEnte(); // mi serve per avere i dati di ente
			 EnteImp x = new EnteImp();
			 Ente ente = new Ente();
			 ente = x.getEnteById(idEnte);
			 
			 
		}
		
		
	}

	public Amministratore getAdminById(int id) {
	
		Connection conn = DAO.getConnection();		
		String query="select * from amministratore a where a.idAdmin = "+ id +" ;" ;
		ResultSet rs;
		Amministratore am = new Amministratore();
		am.setIdAdmin(id);
		try {
			rs = DAO.execute_Query(conn, query );
			if(rs.first()==true) 
			{ 
				am.setEmailAdmin(rs.getString("emailAdmin"));
				am.setPswAdmin(rs.getString("pswAdmin"));
			}	
		}catch(SQLException e) {}
	
		return am;
	}
		
	
}


	
	



















/*Connection conn=null;

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
    if(conn==null) conn=(Connection) DAO.getConnection();
    Statement st = conn.createStatement();
    String email = "";
    
    ResultSet rs = st.executeQuery("select emailAdmin from amministratore where idAdmin="+idAdmin);
    try {
    	rs.first();
    	email=rs.getString("email");
    }catch(SQLException e) {
    	return "";
    }
    return email;
}
*/



package com.mercury.model.dao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import com.mercury.model.Ente;
import com.mercury.model.EventoPrevisto;
import com.mysql.jdbc.Connection;

public class AmministratoreImp  implements AmministratoreUtil {
	
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
	
	
	public void InvioMailAbilitaEnte(Ente en) {
	String mitt = " mercury.sincronoX@gmail.com";
    String dest = en.getEmailEnte();
    String oggetto = "mail di conferma per accedere come ente a www.mercury.it";
    String testo = "l'admin ha confermato la tua registrazione, puoi accedere al sito con";
    
				
	}
	
/*

    String mitt = request.getParameter("mittente");
    String dest = request.getParameter("destinatario");
    String oggetto = request.getParameter("oggetto");
    String testo = request.getParameter("contenuto");

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    try
    {
      MailUtility.sendMail(dest, mitt, oggetto, testo);
      out.println("Invio messaggio OK!");
    }
    catch (MessagingException exc)
    {
      out.println("Invio non riuscito!");
      log("MessagingException: " + dest);
      log(exc.toString());
    }
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException
  {
    this.doPost(request, response);
  }
}
	 * 
	 * 
	 * */





	public void checkEvento(EventoPrevisto ep, int idEnte) {
		// TODO Auto-generated method stub
		
	}
	
	

}

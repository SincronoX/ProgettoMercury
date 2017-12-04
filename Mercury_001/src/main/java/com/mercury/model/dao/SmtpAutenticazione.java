package com.mercury.model.dao;



import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;


public class SmtpAutenticazione extends Authenticator {
    private String user;
    private String psw;
    
    public SmtpAutenticazione(String user, String psw){
        super();
        this.user = user;
        this.psw = psw;
    }
    
    
    @Override
    public PasswordAuthentication getPasswordAuthentication(){
        return new PasswordAuthentication(user, psw);
    }
    
}

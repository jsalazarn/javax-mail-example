package com.jimmysalazar.javax.mail;

import java.util.Properties;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	System.out.println("SimpleEmail Start");
    	
    	final String username = "EMAIL_OWNER";
        final String password = "PASSWORD_OWNER";
        
	    String smtpHostServer = "smtp.gmail.com";
	    String mailTo = "jimmyr.salazar@gmail.com";
	    
	    Properties props = System.getProperties();
	    
	    props.put("mail.smtp.host", smtpHostServer);
	    props.put("mail.smtp.port", "587");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.smtp.auth", "true");

	    Session session = Session.getInstance(props,
	            new javax.mail.Authenticator() {
	                protected PasswordAuthentication getPasswordAuthentication() {
	                    return new PasswordAuthentication(username, password);
	                }
	            });
	    
	    //EmailUtil.sendEmail(session, emailID,"SimpleEmail Testing Subject", "SimpleEmail Testing Body");
	    EmailUtil.sendEmailWithImage(session, mailTo,"SimpleEmail Testing Subject", "SimpleEmail Testing Body");
	}
}

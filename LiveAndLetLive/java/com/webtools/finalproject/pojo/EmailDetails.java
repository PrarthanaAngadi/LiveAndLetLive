package com.webtools.finalproject.pojo;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailDetails {
	
	public boolean sendMail(String from,String password,String message,String to, String subject) throws Exception 
    {
        String host = "smtp.gmail.com";
        Properties props = System.getProperties();
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.user", password);
        props.put("mail.smtp.port", 587);
        props.put("mail.smtp.auth", "true");
        Session session = Session.getDefaultInstance(props,null);
        MimeMessage mimeMessage = new MimeMessage(session);
        try{
            mimeMessage.setFrom(new InternetAddress(from));
           InternetAddress address = new InternetAddress(to);
           mimeMessage.setRecipient(Message.RecipientType.TO, address);
           mimeMessage.setSubject(subject);
           mimeMessage.setText(message);
           Transport transport = session.getTransport("smtp");
           transport.connect(host,from,password);
           transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
           transport.close();
           return true;
           
        }
        catch(MessagingException e)
        {
            throw new Exception("Error occurred while sending Email please check the email id & the connection" +e);
        }
        
        
                
                
        
    }
    

}

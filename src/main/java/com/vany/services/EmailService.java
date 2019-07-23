package com.vany.services;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
    private JavaMailSender javaMailSender;
	
	public void sendEmail(String toAddress,String subject,String body) {
		try {
			Properties props= System.getProperties();
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "456");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.socketFactory.fallback", "false");
			
			Session mailSession=Session.getDefaultInstance(props,null);
			mailSession.setDebug(true);

			Message mailMessage= new MimeMessage(mailSession);
			mailMessage.setFrom(new InternetAddress("vsurwshe@gmail.com"));
			mailMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(toAddress));
			mailMessage.setContent(body, "text/html");
			mailMessage.setSubject(subject);
			
			Transport transport=mailSession.getTransport("smtp");
			transport.connect("smtp.gmail.com","vsurwshe@gmail.com","Vishv@nath96");
			
			transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
			
//			  SimpleMailMessage msg = new SimpleMailMessage();
//		        msg.setTo(toAddress);
//		        msg.setSubject(subject);
//		        msg.setText(body);
//		        javaMailSender.send(msg);

			
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		
      
    }
	
}












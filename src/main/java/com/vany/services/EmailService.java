package com.vany.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class EmailService {

	@Autowired
    private JavaMailSender javaMailSender;
	
	public void sendEmail(String toAddress,String subject,String body) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(toAddress);
        msg.setSubject(subject);
        msg.setText(body);
        javaMailSender.send(msg);

    }
	
}

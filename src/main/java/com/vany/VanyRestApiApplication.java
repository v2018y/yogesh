package com.vany;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import com.vany.services.EmailService;

@SpringBootApplication
public class VanyRestApiApplication {

	
	@Autowired
	private static EmailService emailSerivce;
	
	public static void main(String[] args) {
		SpringApplication.run(VanyRestApiApplication.class, args);
	}
	
	 public void run() throws MessagingException, IOException {
		 System.out.println("Sending Email...");
	        emailSerivce.sendEmail("iamvishvanath@gmail.com","Test Mail","Hi This Is Sample Mail.");
	        System.out.println("Done");
	 }
	
	
}

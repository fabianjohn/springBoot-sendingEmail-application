package com.fabiscode.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.fabiscode.mail.service.EmailSenderService;

import jakarta.mail.MessagingException;




@SpringBootApplication
public class SpringBootSendingemailApplication {
	@Autowired
    private EmailSenderService service;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSendingemailApplication.class, args);
	}
	
   

//	@EventListener(ApplicationReadyEvent.class)
//	public void triggerMail(){
		
//		service.sendSimpleEmail("fabianitafor0358@gmail.com", "this is mail body", "this is mail subject");
		
		
		
//	}    
	
	@EventListener(ApplicationReadyEvent.class)
	public void triggerMimeMessage() throws MessagingException {
	service.sendEmailWithAttachement("fabianitafor0358@gmail.com", "this is mail body", "this is mail body", 
			"C:\\Users\\lenovo\\Documents\\JAVA GUID - ENTITY MANAGER INJECTION.docx"); 
			
		
	}
	
		
	
}



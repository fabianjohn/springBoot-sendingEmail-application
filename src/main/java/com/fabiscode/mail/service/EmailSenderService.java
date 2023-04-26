package com.fabiscode.mail.service;


import java.io.File;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailSenderService {
	
	@Autowired
	
	private JavaMailSender mailSender;
	
//	public void sendSimpleEmail(String toEmail, String body, String subject) {
		
//		SimpleMailMessage message = new SimpleMailMessage();
//		message.setFrom("fabita.aws@gmail.com");
//		message.setTo(toEmail);
//		message.setText(body);
//		message.setSubject(subject);
		
//		mailSender.send(message);
		
//		System.out.println("Message sent...");
//	}
	
	public void sendEmailWithAttachement(String toEmail, String body, String subject, String attachement) throws MessagingException  {
		MimeMessage mm = mailSender.createMimeMessage();
		
		MimeMessageHelper mmh = new MimeMessageHelper(mm, true);
		
		mmh.setFrom("fabita.aws@gmail.com");
		mmh.setTo(toEmail);
		mmh.setText(body);
		mmh.setSubject(subject);
		FileSystemResource fsr = new FileSystemResource( new File(attachement));
		mmh.addAttachment(fsr.getFilename(), fsr);
		mailSender.send(mm);
		System.out.println("fileSystem send");
	}
	

}

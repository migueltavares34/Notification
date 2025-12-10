package com.example.demo.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.model.Email;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class NotificationBusiness {

	@Autowired
	private JavaMailSender mailSender;

	public void sendEmail(Email email) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email.getTo());
		message.setSubject(email.getSubject());
		message.setText(email.getMessageBody());
		mailSender.send(message);
		log.info("email sent - To " + email.getTo() + " about " + email.getSubject());
	}
}
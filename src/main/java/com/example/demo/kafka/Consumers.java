package com.example.demo.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.demo.business.NotificationBusiness;
import com.example.demo.model.Email;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class Consumers {

	@Autowired
	NotificationBusiness notificationBusiness;

	@KafkaListener(topics = "my-first-topic", groupId = "my-first-group")
	public boolean receiveMessage(Email email) {

		log.info(email.toString());
		notificationBusiness.sendEmail(email);
		return true;
	}

}

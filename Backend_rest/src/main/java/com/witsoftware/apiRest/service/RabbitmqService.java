package com.witsoftware.apiRest.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitmqService {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	
	public void enviaMsg(String queueName, Object msg) {
		
		this.rabbitTemplate.convertAndSend(queueName, msg);
		
	}
}

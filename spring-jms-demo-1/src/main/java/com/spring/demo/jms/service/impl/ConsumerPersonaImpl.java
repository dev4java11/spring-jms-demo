package com.spring.demo.jms.service.impl;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Service;

import com.spring.demo.jms.domain.Persona;
import com.spring.demo.jms.service.ConsumerPersona;
import com.spring.demo.jms.util.Constant;

@Service
public class ConsumerPersonaImpl implements ConsumerPersona {
	
	private JmsTemplate template;
	
	@Autowired(required = false)
	public void setTemplate(JmsTemplate template) {
		this.template = template;
	}

	@Override
	public Persona receivePersona() {
		ObjectMessage message = (ObjectMessage) template.receive();
		Persona persona = null;
		try {
			persona = (Persona) message.getObject();
		} catch (JMSException e) {
			e.printStackTrace();
		}
		return persona;
	}
	
	@Override
	@JmsListener(destination = Constant.QUEUE_SPRING_DEMO)
	public void receivePersona(Message<Persona> message) throws JmsException {
		MessageHeaders headers = message.getHeaders();
		System.out.println("headers: "+ headers);
		Persona persona = message.getPayload();
		System.out.println("persona: "+ persona.toString());
	}

}

package com.spring.demo.jms.service.impl;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.spring.demo.jms.domain.Persona;
import com.spring.demo.jms.service.ProducerPersona;

@Service
public class ProducerPersonaImpl implements ProducerPersona {

	private JmsTemplate template;
	
	@Autowired
	public void setTemplate(JmsTemplate template) {
		this.template = template;
	}
	
	@Override
	public void sendPersona(Persona persona) {
		template.send(new MessageCreator() {
			
			@Override
			public Message createMessage(Session session) throws JMSException {
				ObjectMessage obj = session.createObjectMessage(persona);
				return obj;
			}
		});
	}

}

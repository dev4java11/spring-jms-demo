package com.spring.demo.jms.service;

import org.springframework.jms.JmsException;
import org.springframework.messaging.Message;

import com.spring.demo.jms.domain.Persona;

public interface ConsumerPersona {

	public Persona receivePersona();
	
	public void receivePersona(Message<Persona> message) throws JmsException;
}

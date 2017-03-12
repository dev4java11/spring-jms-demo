package com.spring.demo.jms.test.topic;


import java.math.BigDecimal;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.demo.jms.configuration.ActiveMQConfiguration;
import com.spring.demo.jms.configuration.JMSConfiguration;
import com.spring.demo.jms.domain.Persona;
import com.spring.demo.jms.service.ProducerPersona;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {ActiveMQConfiguration.class, JMSConfiguration.class})
@ActiveProfiles("topic")
public class JmsTestProducerTopic {

	@Autowired
	private ProducerPersona producer;
	
	@Test
	public void sendPersonaTest() throws InterruptedException{
		TimeUnit.SECONDS.sleep(20);
		Persona persona = new Persona("1", "Nilo Hernán Rosas Nutz", "Masculino", 26, new BigDecimal(2500), new Date(1991, 3, 14));
		producer.sendPersona(persona);
		TimeUnit.MINUTES.sleep(1);
	}
}

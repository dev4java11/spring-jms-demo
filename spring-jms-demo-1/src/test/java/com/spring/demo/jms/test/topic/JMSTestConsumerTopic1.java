package com.spring.demo.jms.test.topic;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.demo.jms.configuration.ActiveMQConfiguration;
import com.spring.demo.jms.configuration.JMSConfiguration;
import com.spring.demo.jms.domain.Persona;
import com.spring.demo.jms.service.ConsumerPersona;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {JMSConfiguration.class})
@ActiveProfiles("topic")
public class JMSTestConsumerTopic1 {

	@Autowired
	private ConsumerPersona consumer;
	
	@Test
	public void consumePersonaTest(){
		Persona persona = consumer.receivePersona();
		Assert.assertNotNull(persona);
		if(persona != null){
			System.out.println(persona.toString());
		}
	}
}

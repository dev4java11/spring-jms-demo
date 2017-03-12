package com.spring.demo.jms.test.listener;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.demo.jms.configuration.JMSListenerConfiguration;
import com.spring.demo.jms.service.ConsumerPersona;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {JMSListenerConfiguration.class})
public class JmsTestConsumerListener {

	private ConsumerPersona consumer;
	
	@Test
	public void consumePersonaTest() throws InterruptedException{
		TimeUnit.MINUTES.sleep(1);
	}
}

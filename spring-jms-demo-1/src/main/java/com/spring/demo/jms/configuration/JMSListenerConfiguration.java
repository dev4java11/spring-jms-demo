package com.spring.demo.jms.configuration;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

import com.spring.demo.jms.util.Constant;

@Configuration
@ComponentScan("com.spring.demo.jms.service")
@EnableJms
public class JMSListenerConfiguration {
	
	@Bean
	public ActiveMQConnectionFactory connectionFactory(){
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
		connectionFactory.setTrustAllPackages(true);
		return connectionFactory;
	}
	
	@Bean
//	@Profile("queue")
	public ActiveMQQueue activeMQQueue(){
		ActiveMQQueue queue = new ActiveMQQueue(Constant.QUEUE_SPRING_DEMO);
		return queue;
	}
	
	@Bean
//	@Profile("queue")
	public JmsTemplate templateQueue(){
		JmsTemplate template = new JmsTemplate();
		template.setConnectionFactory(connectionFactory());
		template.setDefaultDestination(activeMQQueue());
		return template;
	}

	@Bean(name = "jmsListenerContainerFactory")
	public DefaultJmsListenerContainerFactory factory(){
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory());
		factory.setConcurrency("5-5");
		return factory;
	}
}

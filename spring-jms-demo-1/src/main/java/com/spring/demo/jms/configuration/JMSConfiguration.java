package com.spring.demo.jms.configuration;


import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.apache.activemq.jms.pool.PooledConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.core.JmsTemplate;

import com.spring.demo.jms.util.Constant;

@Configuration
@ComponentScan("com.spring.demo.jms.service")
public class JMSConfiguration {

	@Bean
	public ActiveMQConnectionFactory connectionFactory(){
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
		connectionFactory.setTrustAllPackages(true);
		return connectionFactory;
	}
	
	@Bean
	@Profile("queue")
	public ActiveMQQueue activeMQQueue(){
		ActiveMQQueue queue = new ActiveMQQueue(Constant.QUEUE_SPRING_DEMO);
		return queue;
	}
	
	@Bean
	@Profile("topic")
	public ActiveMQTopic activeMQTopic(){
		ActiveMQTopic topic = new ActiveMQTopic(Constant.TOPIC_SPRING_DEMO);
		return topic;
	}
	
	
	@Bean
	@Profile("queue")
	public JmsTemplate templateQueue(){
		JmsTemplate template = new JmsTemplate();
		template.setConnectionFactory(connectionFactory());
		template.setDefaultDestination(activeMQQueue());
		return template;
	}
	
	@Bean
	@Profile("topic")
	public JmsTemplate templateTopic(){
		JmsTemplate template = new JmsTemplate();
		template.setConnectionFactory(connectionFactory());
		template.setDefaultDestination(activeMQTopic());
		template.setPubSubDomain(true);
		return template;
	}
	
}

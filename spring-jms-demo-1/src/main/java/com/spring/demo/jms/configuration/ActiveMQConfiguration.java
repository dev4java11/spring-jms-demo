package com.spring.demo.jms.configuration;

import org.apache.activemq.broker.BrokerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ActiveMQConfiguration {

	@Bean
	public BrokerService brokerService() throws Exception{
		BrokerService broker = new BrokerService();
		broker.setPersistent(false);
		broker.setUseJmx(false);
		broker.setBrokerName("broker");
		broker.addConnector("tcp://localhost:61616");
		broker.setUseShutdownHook(false);
		return broker;
	}
}

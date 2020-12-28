package com.pandeys.externalactivemq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
@EnableJms
public class SpringMessageSender {

	private static final String QUEUE_NAME = "com.pandeys.textMsgQueue.springannotation.sb";
	
	public static void main(String[] args) {
		
		ConfigurableApplicationContext context = SpringApplication.run(SpringMessageSender.class, args);
		JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
		
		Product product1 = new Product(101, "ProductA", 1001);
		Product product2 = new Product(102, "ProductB", 1002);
		Product product3 = new Product(103, "ProductC", 1003);
		System.out.println("Sending Products");
		jmsTemplate.convertAndSend(QUEUE_NAME, product1);
		jmsTemplate.convertAndSend(QUEUE_NAME, product2);
		jmsTemplate.convertAndSend(QUEUE_NAME, product3);
	}

}

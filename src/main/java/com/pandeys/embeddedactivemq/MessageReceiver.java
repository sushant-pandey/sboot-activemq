package com.pandeys.embeddedactivemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

@Component("sbProductReceiver")
public class MessageReceiver{

	private static final String QUEUE_NAME = "com.pandeys.textMsgQueue.springannotation.sb";	
	
	@JmsListener(destination = QUEUE_NAME)
	public void receiveMessage(Product product) {
		System.out.println("Product Received");
		System.out.println(product);
	}
}

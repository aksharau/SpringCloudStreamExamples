package com.example.cloudStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class MsgListener {
	
	@Autowired
	private MsgWriter writer;
	
    @StreamListener(StreamsForTheProject.INPUT)
    public void processMessage(Message<String> message) {
    	Acknowledgment acknowledgment = message.getHeaders().get(KafkaHeaders.ACKNOWLEDGMENT, Acknowledgment.class);
    	String msgToWrite = message.getPayload().toString();
    	System.out.println("The message received is: " + msgToWrite);
    	System.out.println("About to write it to next topic....");
    	
    	writer.publish(msgToWrite.toUpperCase());
    	
        if (acknowledgment != null) {
            System.out.println("Acknowledgment provided");
            acknowledgment.acknowledge();
        }
    }
}

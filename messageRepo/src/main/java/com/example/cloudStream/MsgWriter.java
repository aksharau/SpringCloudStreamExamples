package com.example.cloudStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeTypeUtils;

@Component
public class MsgWriter {
	
	private MessageChannel output;

    @Autowired
    public MsgWriter(@Qualifier(StreamsForTheProject.OUTPUT) MessageChannel output) {
        this.output = output;
    }
    
    public void publish(String name) {
        this.output.send(MessageBuilder.withPayload(name).build());
   }

}

package com.circuit.custom_mq.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import jakarta.jms.Message;
import jakarta.jms.MessageListener;

@Component
public class CustomJMSConsumer implements MessageListener {


    @Override
    @JmsListener(destination = "${active-mq.queue}")
    public void onMessage(Message message) {
        try{
            String rcveMessage = message.toString();
            System.out.println("Received Message: "+ rcveMessage);
        } catch(Exception e) {
        	System.out.println("Received Exception : "+ e);
        }

    }

}

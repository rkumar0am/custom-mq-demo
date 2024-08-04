package com.circuit.custom_mq.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;


@Component
public class CustomJMSProducer {

    @Autowired
    JmsTemplate jmsTemplate;

    @Value("${active-mq.queue}")
    private String topic;

    public void sendMessage(String message){
        try{
            System.out.println("Attempting Send message to Topic: "+ topic);
            jmsTemplate.convertAndSend(topic, message);
        } catch(Exception e){
        	System.out.println("Recieved Exception during send Message: "+ e);
        }
    }
}

package com.circuit.custom_mq.initiation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.circuit.custom_mq.jms.CustomJMSProducer;

@RestController
public class CustomController {
	

	@Autowired
    CustomJMSProducer jmsProducer;
	
    @PostMapping(value="/triggerMessage")
    public String triggerMessage(@RequestBody String message){
        jmsProducer.sendMessage(message);
        return "Message Sent";
    }

}

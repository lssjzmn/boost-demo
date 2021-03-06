package com.lssjzmn.kilin.boost.boostclient.amqp;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AmqpMessageSender {

    @Autowired
    AmqpTemplate amqpTemplate;

    //key="${rabbitmq.queue}_routingkey"
    public void sendMessage(String routingKey, Object msg) {
        amqpTemplate.convertAndSend(routingKey, msg);
    }

}

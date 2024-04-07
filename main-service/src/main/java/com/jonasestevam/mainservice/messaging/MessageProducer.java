package com.jonasestevam.mainservice.messaging;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.stereotype.Component;

import com.jonasestevam.domain.entities.Sale;

@Component
public class MessageProducer {

    private final RabbitTemplate rabbitTemplate;

    public MessageProducer(RabbitTemplate rabbitTemplate) {
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        this.rabbitTemplate = rabbitTemplate;
    }

    public void proccessPayment(Sale sale) {
        Map<String, Object> message = new HashMap<>();
        message.put("sale", sale);
        rabbitTemplate.convertAndSend("paymentQueue", message);
    }
}

package com.jonasestevam.mspayment.producer;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.stereotype.Component;

import com.jonasestevam.domain.entities.Sale;

@Component
public class PaymentProducer {

    private final RabbitTemplate rabbitTemplate;

    public PaymentProducer(RabbitTemplate rabbitTemplate) {
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        this.rabbitTemplate = rabbitTemplate;
    }

    public void notifyPaymentProcess(Sale sale) {
        Map<String, Object> message = new HashMap<>();
        message.put("processedSale", sale);
        rabbitTemplate.convertAndSend("paymentQueue", message);
    }
}

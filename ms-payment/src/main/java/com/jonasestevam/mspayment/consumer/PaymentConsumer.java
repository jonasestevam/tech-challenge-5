package com.jonasestevam.mspayment.consumer;

import java.util.Map;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jonasestevam.domain.entities.Sale;
import com.jonasestevam.mspayment.services.PaymentService;

@Component
public class PaymentConsumer {

    @Autowired
    PaymentService service;

    @RabbitListener(queues = "paymentQueue")
    public void receiveMessage(Map<String, Object> message) throws InterruptedException {
        Object saleObject = message.get("sale");
        if (saleObject instanceof Sale) {
            Sale sale = (Sale) saleObject;
            service.processSale(sale);
        }
    }

}

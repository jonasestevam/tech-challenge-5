package com.jonasestevam.mainservice.messaging;

import java.util.Map;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jonasestevam.domain.entities.Sale;
import com.jonasestevam.mainservice.services.SaleService;

@Component
public class PaymentConsumer {

    @Autowired
    SaleService saleService;

    @RabbitListener(queues = "paymentQueue")
    public void receiveMessage(Map<String, Object> message) throws InterruptedException {
        Object saleObject = message.get("processedSale");
        if (saleObject instanceof Sale) {
            Sale sale = (Sale) saleObject;
            saleService.save(sale);
        }
    }

}

package com.jonasestevam.mspayment.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.jonasestevam.domain.entities.Sale;
import com.jonasestevam.domain.enums.SaleStatus;
import com.jonasestevam.mspayment.producer.PaymentProducer;

public class PaymentService {
    @Autowired
    PaymentProducer producer;

    public void processSale(Sale sale) throws InterruptedException {
        // simula processamento do pagamento
        Thread.sleep(120000);
        sale.setStatus(SaleStatus.PENDING_DELIVERY);
        producer.notifyPaymentProcess(sale);

    }
}

package com.jonasestevam.mainservice.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingConfig {
    @Bean
    Queue paymentQueue() {
        return new Queue("paymentQueue");
    }
}
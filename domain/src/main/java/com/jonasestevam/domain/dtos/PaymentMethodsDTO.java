package com.jonasestevam.domain.dtos;

import java.util.UUID;

import com.jonasestevam.domain.enums.PaymentMethodsTypes;

import lombok.Data;

@Data
public class PaymentMethodsDTO {

    private UUID id;

    private PaymentMethodsTypes paymentMethodsType;

    private Boolean isAative;
    private UserDTO buyer;

}

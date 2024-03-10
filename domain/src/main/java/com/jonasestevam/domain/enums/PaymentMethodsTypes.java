package com.jonasestevam.domain.enums;

public enum PaymentMethodsTypes {
    CREDIT_CARD("Credit card"),
    DEBIT_CARD("Debit card"),
    PIX("PIX");

    private String name;

    PaymentMethodsTypes(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

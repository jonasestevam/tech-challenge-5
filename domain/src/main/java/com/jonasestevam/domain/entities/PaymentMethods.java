package com.jonasestevam.domain.entities;

import java.util.UUID;

import com.jonasestevam.domain.enums.PaymentMethodsTypes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class PaymentMethods {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "payment_method_id")
    private UUID id;

    @Enumerated(EnumType.STRING)
    private PaymentMethodsTypes paymentMethodsType;

    @Column
    private Boolean isAative;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private Buyer buyer;

}

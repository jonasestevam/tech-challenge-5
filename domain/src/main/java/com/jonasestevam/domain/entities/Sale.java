package com.jonasestevam.domain.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.jonasestevam.domain.enums.SaleStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToMany
    private List<Product> products;

    @Column(nullable = false)
    private Double total;

    @Column(nullable = false)
    private LocalDateTime date;

    @Enumerated(EnumType.STRING)
    private SaleStatus status;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private Buyer buyer;

    @ManyToOne()
    @JoinColumn(name = "address_id")
    private Address shippingAddress;

    @ManyToOne()
    @JoinColumn(name = "payment_method_id")
    private PaymentMethods paymentMethod;
}

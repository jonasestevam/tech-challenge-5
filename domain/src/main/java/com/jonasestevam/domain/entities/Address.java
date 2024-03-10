package com.jonasestevam.domain.entities;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "address_id")
    private UUID id;

    @Column
    private String zipCode;

    @Column
    private String city;

    @Column
    private String state;

    @Column
    private String street;

    @Column
    private String number;

    @ManyToOne()
    @JoinColumn(name = "buyer_id")
    private Buyer buyer;

    @Column
    private Boolean isAative;
}

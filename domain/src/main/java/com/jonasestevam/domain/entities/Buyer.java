package com.jonasestevam.domain.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
public class Buyer extends User {

    @OneToMany(mappedBy = "buyer", cascade = CascadeType.ALL)
    private List<Address> shippingAddresses;

    @OneToMany(mappedBy = "buyer", cascade = CascadeType.ALL)
    private List<PaymentMethods> paymentMethods;

    @OneToMany(mappedBy = "buyer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Sale> sales;
}

package com.jonasestevam.domain.dtos;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.jonasestevam.domain.entities.PaymentMethods;
import com.jonasestevam.domain.entities.Sale;

import lombok.Data;

@Data
public class UserDTO {
    private UUID id;
    private String username;
    private String email;
    private String password;
    private LocalDate registrationDate;
    private String taxPayerNumber;
    private List<AddressDTO> shippingAddresses;
    private List<PaymentMethods> paymentMethods;
    private List<Sale> sales;
    private StoreDTO store;
}

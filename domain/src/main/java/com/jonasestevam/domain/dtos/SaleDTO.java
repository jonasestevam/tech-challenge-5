package com.jonasestevam.domain.dtos;

import java.time.LocalDateTime;
import java.util.List;

import com.jonasestevam.domain.enums.SaleStatus;

import lombok.Data;

@Data
public class SaleDTO {
    private Integer id;

    private List<ProductDTO> products;

    private Double total;

    private LocalDateTime date;

    private SaleStatus status;

    private BuyerDTO buyer;

    private AddressDTO shippingAddress;

    private PaymentMethodsDTO paymentMethod;
}

package com.jonasestevam.domain.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BuyerDTO extends UserDTO {

    private List<AddressDTO> shippingAddresses;

    private List<PaymentMethodsDTO> paymentMethods;

    private List<SaleDTO> sales;
}

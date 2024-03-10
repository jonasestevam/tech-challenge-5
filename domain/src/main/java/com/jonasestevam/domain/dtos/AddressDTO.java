package com.jonasestevam.domain.dtos;

import java.util.UUID;

import lombok.Data;

@Data
public class AddressDTO {
    private UUID id;

    private String zipCode;

    private String city;

    private String state;

    private String street;

    private String number;

    private BuyerDTO buyer;

    private Boolean isAative;
}

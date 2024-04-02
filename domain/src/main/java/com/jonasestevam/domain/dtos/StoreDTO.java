package com.jonasestevam.domain.dtos;

import java.util.UUID;

import lombok.Data;

@Data
public class StoreDTO {
    private UUID id;

    // private List<ProductDTO> products;

    private String name;

    private String taxPayerNumber;

    private String email;
}

package com.jonasestevam.domain.dtos;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.Data;

@Data
public class ProductDTO {

    private UUID id;

    private String name;

    private String description;

    private String brand;

    private BigDecimal price;

    private Integer stockQuantity;

    private String SKU;

    private StoreDTO store;
}

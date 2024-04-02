package com.jonasestevam.domain.dtos;

import java.util.List;
import java.util.UUID;

import lombok.Data;

@Data
public class CartDTO {

    private UUID id;

    private UserDTO usuario;

    private List<ProductDTO> products;
}

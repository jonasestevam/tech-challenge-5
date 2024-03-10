package com.jonasestevam.domain.dtos;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SellerDTO extends UserDTO {
    private UUID storeID;
}

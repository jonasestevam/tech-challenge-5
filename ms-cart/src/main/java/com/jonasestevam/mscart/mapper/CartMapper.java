package com.jonasestevam.mscart.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.jonasestevam.domain.dtos.CartDTO;
import com.jonasestevam.domain.entities.Cart;

@Mapper(componentModel = "spring")
public interface CartMapper extends BaseMapper<CartDTO, Cart> {
    CartMapper INSTANCE = Mappers.getMapper(CartMapper.class);
}

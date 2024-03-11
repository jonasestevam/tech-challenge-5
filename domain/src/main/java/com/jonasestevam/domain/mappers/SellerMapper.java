package com.jonasestevam.domain.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.jonasestevam.domain.dtos.SellerDTO;
import com.jonasestevam.domain.entities.Seller;

@Mapper(componentModel = "spring")
public interface SellerMapper extends BaseMapper<SellerDTO, Seller> {
    SellerMapper INSTANCE = Mappers.getMapper(SellerMapper.class);
}

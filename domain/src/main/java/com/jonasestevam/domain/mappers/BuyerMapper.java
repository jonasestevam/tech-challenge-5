package com.jonasestevam.domain.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.jonasestevam.domain.dtos.BuyerDTO;
import com.jonasestevam.domain.entities.Buyer;

@Mapper(componentModel = "spring")
public interface BuyerMapper extends BaseMapper<BuyerDTO, Buyer> {
    BuyerMapper INSTANCE = Mappers.getMapper(BuyerMapper.class);
}

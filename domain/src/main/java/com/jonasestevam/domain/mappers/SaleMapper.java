package com.jonasestevam.domain.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.jonasestevam.domain.dtos.SaleDTO;
import com.jonasestevam.domain.entities.Sale;

@Mapper(componentModel = "spring")
public interface SaleMapper extends BaseMapper<SaleDTO, Sale> {
    SaleMapper INSTANCE = Mappers.getMapper(SaleMapper.class);
}

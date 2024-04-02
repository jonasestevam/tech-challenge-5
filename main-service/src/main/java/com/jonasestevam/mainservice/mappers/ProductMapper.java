package com.jonasestevam.mainservice.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.jonasestevam.domain.dtos.ProductDTO;
import com.jonasestevam.domain.entities.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper extends BaseMapper<ProductDTO, Product> {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
}

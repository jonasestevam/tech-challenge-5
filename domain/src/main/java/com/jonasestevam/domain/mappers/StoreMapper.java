package com.jonasestevam.domain.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.jonasestevam.domain.dtos.StoreDTO;
import com.jonasestevam.domain.entities.Store;

@Mapper(componentModel = "spring")
public interface StoreMapper extends BaseMapper<StoreDTO, Store> {
    StoreMapper INSTANCE = Mappers.getMapper(StoreMapper.class);
}

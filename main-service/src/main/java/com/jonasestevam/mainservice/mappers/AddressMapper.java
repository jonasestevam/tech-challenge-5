package com.jonasestevam.mainservice.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.jonasestevam.domain.dtos.AddressDTO;
import com.jonasestevam.domain.entities.Address;

@Mapper(componentModel = "spring")
public interface AddressMapper extends BaseMapper<AddressDTO, Address> {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);
}

package com.jonasestevam.mainservice.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.jonasestevam.domain.dtos.PaymentMethodsDTO;
import com.jonasestevam.domain.entities.PaymentMethods;

@Mapper(componentModel = "spring")
public interface PaymentMethodMapper extends BaseMapper<PaymentMethodsDTO, PaymentMethods> {
    PaymentMethodMapper INSTANCE = Mappers.getMapper(PaymentMethodMapper.class);
}

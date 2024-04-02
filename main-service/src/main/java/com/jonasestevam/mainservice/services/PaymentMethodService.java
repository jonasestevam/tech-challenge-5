package com.jonasestevam.mainservice.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jonasestevam.domain.dtos.PaymentMethodsDTO;
import com.jonasestevam.domain.entities.PaymentMethods;
import com.jonasestevam.mainservice.mappers.PaymentMethodMapper;
import com.jonasestevam.mainservice.repositories.PaymentMethodRepository;

@Service
public class PaymentMethodService {

    @Autowired
    PaymentMethodRepository repository;

    @Autowired
    PaymentMethodMapper mapper;

    public PaymentMethodsDTO save(PaymentMethodsDTO newBuyer) {
        return mapper.toDto(repository.save(mapper.toEntity(newBuyer)));
    }

    public List<PaymentMethodsDTO> getById(List<UUID> id) {
        return mapper.toDto(repository.findAllById(id));
    }

    public PaymentMethodsDTO getById(UUID id) {
        Optional<PaymentMethods> buyerOptional = repository.findById(id);

        if (!buyerOptional.isPresent())
            return null;

        return mapper.toDto(buyerOptional.get());
    }

    public List<PaymentMethodsDTO> getAll() {
        return mapper.toDto(repository.findAll());

    }

    public PaymentMethodsDTO update(PaymentMethodsDTO newPaymentMethod) {
        Optional<PaymentMethods> existingBuyerOptional = repository.findById(newPaymentMethod.getId());
        if (existingBuyerOptional.isPresent()) {
            PaymentMethodsDTO existingBuyer = mapper.toDto(existingBuyerOptional.get());

            newPaymentMethod.setId(existingBuyer.getId());

            repository.save(mapper.toEntity(newPaymentMethod));
            return newPaymentMethod;
        } else {
            throw new IllegalArgumentException("Address not found with ID: " +
                    newPaymentMethod.getId());
        }
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}

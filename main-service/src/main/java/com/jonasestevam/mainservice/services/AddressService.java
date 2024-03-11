package com.jonasestevam.mainservice.services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.jonasestevam.domain.dtos.AddressDTO;
import com.jonasestevam.domain.entities.Address;
import com.jonasestevam.domain.mappers.AddressMapper;
import com.jonasestevam.mainservice.repositories.AddressRepository;

import io.micrometer.common.lang.NonNull;

@Service
@SuppressWarnings("null")
public class AddressService {

    @Autowired
    private AddressRepository repository;

    @Autowired
    private AddressMapper mapper;

    public AddressDTO saveAddress(AddressDTO address) {
        return mapper.toDto(repository.save(mapper.toEntity(address)));
    }

    // TODO: Validar dono do endereço
    public AddressDTO updateAddress(AddressDTO address) {
        Optional<Address> existingAddressOptional = repository.findById(address.getId());
        if (existingAddressOptional.isPresent()) {
            AddressDTO existingAddress = mapper.toDto(existingAddressOptional.get());

            address.setId(existingAddress.getId());
            address.setBuyer(existingAddress.getBuyer());

            repository.save(mapper.toEntity(address));
            return address;
        } else {
            throw new IllegalArgumentException("Address not found with ID: " +
                    address.getId());
        }
    }

    // TODO: Validar dono do endereço
    public void deleteAddress(@NonNull UUID id) {
        repository.deleteById(id);
    }

}

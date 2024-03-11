package com.jonasestevam.mainservice.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jonasestevam.domain.dtos.SellerDTO;
import com.jonasestevam.domain.entities.Seller;
import com.jonasestevam.domain.mappers.SellerMapper;
import com.jonasestevam.mainservice.repositories.SellerRespository;

@Service
public class SellerService {
    @Autowired
    SellerRespository repository;

    @Autowired
    SellerMapper mapper;

    public SellerDTO save(SellerDTO newSeller) {
        return mapper.toDto(repository.save(mapper.toEntity(newSeller)));
    }

    public List<SellerDTO> getById(List<UUID> id) {
        return mapper.toDto(repository.findAllById(id));
    }

    public SellerDTO getById(UUID id) {
        Optional<Seller> SellerOptional = repository.findById(id);

        if (!SellerOptional.isPresent())
            return null;

        return mapper.toDto(SellerOptional.get());
    }

    public List<SellerDTO> getAll() {
        return mapper.toDto(repository.findAll());

    }

    public SellerDTO update(SellerDTO newPaymentMethod) {
        Optional<Seller> existingSellerOptional = repository.findById(newPaymentMethod.getId());
        if (existingSellerOptional.isPresent()) {
            SellerDTO existingSeller = mapper.toDto(existingSellerOptional.get());

            newPaymentMethod.setId(existingSeller.getId());

            repository.save(mapper.toEntity(newPaymentMethod));
            return newPaymentMethod;
        } else {
            throw new IllegalArgumentException("Seller not found with ID: " +
                    newPaymentMethod.getId());
        }
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}

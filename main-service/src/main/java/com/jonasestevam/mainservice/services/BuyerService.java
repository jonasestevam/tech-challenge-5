package com.jonasestevam.mainservice.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jonasestevam.domain.dtos.BuyerDTO;
import com.jonasestevam.domain.entities.Buyer;
import com.jonasestevam.domain.mappers.BuyerMapper;
import com.jonasestevam.mainservice.repositories.BuyerRespository;

@Service
public class BuyerService {

    @Autowired
    BuyerRespository repository;

    @Autowired
    BuyerMapper mapper;

    public BuyerDTO save(BuyerDTO newBuyer) {
        return mapper.toDto(repository.save(mapper.toEntity(newBuyer)));
    }

    public List<BuyerDTO> getById(List<UUID> id) {
        return mapper.toDto(repository.findAllById(id));
    }

    public BuyerDTO getById(UUID id) {
        Optional<Buyer> buyerOptional = repository.findById(id);

        if (!buyerOptional.isPresent())
            return null;

        return mapper.toDto(buyerOptional.get());
    }

    public List<BuyerDTO> getAll() {
        return mapper.toDto(repository.findAll());

    }

    public BuyerDTO update(BuyerDTO newBuyer) {
        Optional<Buyer> existingBuyerOptional = repository.findById(newBuyer.getId());
        if (existingBuyerOptional.isPresent()) {
            BuyerDTO existingBuyer = mapper.toDto(existingBuyerOptional.get());

            newBuyer.setId(existingBuyer.getId());

            repository.save(mapper.toEntity(newBuyer));
            return newBuyer;
        } else {
            throw new IllegalArgumentException("Address not found with ID: " +
                    newBuyer.getId());
        }
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

}

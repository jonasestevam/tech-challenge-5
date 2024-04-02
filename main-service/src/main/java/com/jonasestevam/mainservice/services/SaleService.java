package com.jonasestevam.mainservice.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jonasestevam.domain.dtos.SaleDTO;
import com.jonasestevam.domain.entities.Sale;
import com.jonasestevam.mainservice.mappers.SaleMapper;
import com.jonasestevam.mainservice.repositories.SaleRepository;

@Service
public class SaleService {
    @Autowired
    SaleRepository repository;

    @Autowired
    SaleMapper mapper;

    public SaleDTO save(SaleDTO newSale) {
        return mapper.toDto(repository.save(mapper.toEntity(newSale)));
    }

    public List<SaleDTO> getById(List<UUID> id) {
        return mapper.toDto(repository.findAllById(id));
    }

    public SaleDTO getById(UUID id) {
        Optional<Sale> saleOptional = repository.findById(id);

        if (!saleOptional.isPresent())
            return null;

        return mapper.toDto(saleOptional.get());
    }

    public List<SaleDTO> getAll() {
        return mapper.toDto(repository.findAll());

    }

    public SaleDTO update(SaleDTO newPaymentMethod) {
        Optional<Sale> existingSaleOptional = repository.findById(newPaymentMethod.getId());
        if (existingSaleOptional.isPresent()) {
            SaleDTO existingSale = mapper.toDto(existingSaleOptional.get());

            newPaymentMethod.setId(existingSale.getId());

            repository.save(mapper.toEntity(newPaymentMethod));
            return newPaymentMethod;
        } else {
            throw new IllegalArgumentException("Sale not found with ID: " +
                    newPaymentMethod.getId());
        }
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}

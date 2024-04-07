package com.jonasestevam.mainservice.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jonasestevam.domain.dtos.SaleDTO;
import com.jonasestevam.domain.entities.Sale;
import com.jonasestevam.mainservice.mappers.SaleMapper;
import com.jonasestevam.mainservice.messaging.MessageProducer;
import com.jonasestevam.mainservice.repositories.SaleRepository;

@Service
public class SaleService {
    @Autowired
    SaleRepository repository;

    @Autowired
    MessageProducer messageProducer;

    @Autowired
    SaleMapper mapper;

    public SaleDTO save(SaleDTO newSale) {
        var sale = repository.save(mapper.toEntity(newSale));
        messageProducer.proccessPayment(sale);
        return mapper.toDto(sale);
    }

    public void save(Sale sale) {
        repository.save(sale);
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

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}

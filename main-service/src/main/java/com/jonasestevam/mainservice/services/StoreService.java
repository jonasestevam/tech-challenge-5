package com.jonasestevam.mainservice.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jonasestevam.domain.dtos.StoreDTO;
import com.jonasestevam.domain.entities.Store;
import com.jonasestevam.domain.mappers.StoreMapper;
import com.jonasestevam.mainservice.repositories.StoreRepository;

@Service
public class StoreService {
    @Autowired
    StoreRepository repository;

    @Autowired
    StoreMapper mapper;

    public StoreDTO save(StoreDTO newStore) {
        return mapper.toDto(repository.save(mapper.toEntity(newStore)));
    }

    public List<StoreDTO> getById(List<UUID> id) {
        return mapper.toDto(repository.findAllById(id));
    }

    public StoreDTO getById(UUID id) {
        Optional<Store> storeOptional = repository.findById(id);

        if (!storeOptional.isPresent())
            return null;

        return mapper.toDto(storeOptional.get());
    }

    public List<StoreDTO> getAll() {
        return mapper.toDto(repository.findAll());

    }

    public StoreDTO update(StoreDTO newPaymentMethod) {
        Optional<Store> existingStoreOptional = repository.findById(newPaymentMethod.getId());
        if (existingStoreOptional.isPresent()) {
            StoreDTO existingStore = mapper.toDto(existingStoreOptional.get());

            newPaymentMethod.setId(existingStore.getId());

            repository.save(mapper.toEntity(newPaymentMethod));
            return newPaymentMethod;
        } else {
            throw new IllegalArgumentException("Store not found with ID: " +
                    newPaymentMethod.getId());
        }
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}

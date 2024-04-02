package com.jonasestevam.msproductmanagement.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.jonasestevam.domain.dtos.ProductDTO;
import com.jonasestevam.domain.dtos.StoreDTO;
import com.jonasestevam.domain.interfaces.StoreServiceInterface;
import com.jonasestevam.msproductmanagement.mapper.ProductMapper;
import com.jonasestevam.msproductmanagement.mapper.StoreMapper;
import com.jonasestevam.msproductmanagement.repository.ProductRepository;
import com.jonasestevam.msproductmanagement.repository.StoreRepository;

@Service
public class StoreService implements StoreServiceInterface {
    @Autowired
    StoreRepository repository;

    @Autowired
    StoreMapper mapper;

    @Autowired
    ProductMapper productMapper;

    @Autowired
    ProductRepository productRepository;

    @Override
    public StoreDTO save(StoreDTO newStore) {
        return mapper.toDto(repository.save(mapper.toEntity(newStore)));
    }

    @Override
    public ProductDTO addProduct(ProductDTO productDTO, String storeId)
            throws NotFoundException {
        var storeDb = repository.findById(UUID.fromString(storeId)).orElseThrow(() -> new NotFoundException());

        var productDb = productRepository.save(productMapper.toEntity(productDTO));

        productDb.setStore(storeDb);

        productRepository.save(productDb);
        return productMapper.toDto(productDb);
    }

    // public List<StoreDTO> getById(List<UUID> id) {
    // return mapper.toDto(repository.findAllById(id));
    // }

    // public StoreDTO getById(UUID id) {
    // Optional<Store> storeOptional = repository.findById(id);

    // if (!storeOptional.isPresent())
    // return null;

    // return mapper.toDto(storeOptional.get());
    // }

    // public List<StoreDTO> getAll() {
    // return mapper.toDto(repository.findAll());

    // }

    // public StoreDTO update(StoreDTO newPaymentMethod) {
    // Optional<Store> existingStoreOptional =
    // repository.findById(newPaymentMethod.getId());
    // if (existingStoreOptional.isPresent()) {
    // StoreDTO existingStore = mapper.toDto(existingStoreOptional.get());

    // newPaymentMethod.setId(existingStore.getId());

    // repository.save(mapper.toEntity(newPaymentMethod));
    // return newPaymentMethod;
    // } else {
    // throw new IllegalArgumentException("Store not found with ID: " +
    // newPaymentMethod.getId());
    // }
    // }

    // public void delete(UUID id) {
    // repository.deleteById(id);
    // }
}

package com.jonasestevam.mainservice.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jonasestevam.domain.dtos.ProductDTO;
import com.jonasestevam.domain.entities.Product;
import com.jonasestevam.mainservice.mappers.ProductMapper;
import com.jonasestevam.mainservice.repositories.ProductRepository;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    @Autowired
    ProductMapper mapper;

    public ProductDTO save(ProductDTO newProduct) {
        return mapper.toDto(repository.save(mapper.toEntity(newProduct)));
    }

    public List<ProductDTO> getById(List<UUID> id) {
        return mapper.toDto(repository.findAllById(id));
    }

    public ProductDTO getById(UUID id) {
        Optional<Product> productOptional = repository.findById(id);

        if (!productOptional.isPresent())
            return null;

        return mapper.toDto(productOptional.get());
    }

    public List<ProductDTO> getAll() {
        return mapper.toDto(repository.findAll());

    }

    public ProductDTO update(ProductDTO newPaymentMethod) {
        Optional<Product> existingProductOptional = repository.findById(newPaymentMethod.getId());
        if (existingProductOptional.isPresent()) {
            ProductDTO existingProduct = mapper.toDto(existingProductOptional.get());

            newPaymentMethod.setId(existingProduct.getId());

            repository.save(mapper.toEntity(newPaymentMethod));
            return newPaymentMethod;
        } else {
            throw new IllegalArgumentException("Product not found with ID: " +
                    newPaymentMethod.getId());
        }
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}

package com.jonasestevam.domain.interfaces;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.jonasestevam.domain.dtos.ProductDTO;
import com.jonasestevam.domain.dtos.StoreDTO;

public interface StoreServiceInterface {
    public StoreDTO save(StoreDTO newStore);

    public ProductDTO addProduct(ProductDTO productDTO, String storeId) throws NotFoundException;
}

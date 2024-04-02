package com.jonasestevam.msproductmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jonasestevam.domain.dtos.ProductDTO;
import com.jonasestevam.domain.dtos.StoreDTO;
import com.jonasestevam.msproductmanagement.service.StoreService;

@RestController
@RequestMapping("store")
public class StoreController {

    @Autowired
    StoreService storeService;

    @PostMapping
    public ResponseEntity<StoreDTO> createStore(@RequestBody StoreDTO newStore) {
        return ResponseEntity.ok(storeService.save(newStore));
    }

    @PostMapping("product/{storeId}")
    public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO newProduct,
            @PathVariable("storeId") String storeId) throws NotFoundException {
        return ResponseEntity.ok(storeService.addProduct(newProduct, storeId));
    }
}

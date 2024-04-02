package com.jonasestevam.mainservice.controllers;

import javax.naming.NameNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jonasestevam.domain.dtos.ProductDTO;
import com.jonasestevam.domain.dtos.StoreDTO;
import com.jonasestevam.mainservice.security.AuthenticationService;
import com.jonasestevam.mainservice.services.StoreService;

@RestController
@RequestMapping("store")
public class StoreController {

    @Autowired
    StoreService storeService;

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping
    public ResponseEntity<StoreDTO> createStore(@RequestBody StoreDTO newStore,
            @RequestHeader(value = "Authorization", required = true) String authorizationHeader)
            throws NameNotFoundException {
        String token = authorizationHeader.substring(7);
        var savedStore = storeService.save(newStore);
        // storeService.addOwnerToStore(authenticationService.getLoggedUserByToken(token), savedStore);
        return ResponseEntity.ok(savedStore);
    }

    @PostMapping("/product/{storeId}")
    public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO newProd,
            @PathVariable("storeId") String storeId) {
        return ResponseEntity.ok(storeService.addProduct(newProd, storeId));
    }

}

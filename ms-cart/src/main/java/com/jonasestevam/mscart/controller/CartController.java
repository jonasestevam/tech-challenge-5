package com.jonasestevam.mscart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jonasestevam.domain.dtos.CartDTO;
import com.jonasestevam.mscart.service.CartService;

@RestController
@RequestMapping("cart")
public class CartController {
    @Autowired
    CartService cartService;

    @PostMapping("{productId}/{userId}")
    public ResponseEntity<CartDTO> addToCart(

            @PathVariable("productId") String productId, @PathVariable("userId") String userId) throws NotFoundException {
        return ResponseEntity.ok(cartService.addProdToCart(userId, productId));
    }
}

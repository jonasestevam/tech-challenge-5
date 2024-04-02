package com.jonasestevam.mainservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jonasestevam.domain.dtos.CartDTO;
import com.jonasestevam.mainservice.client.CartClient;

@Service
public class CartService {

    @Autowired
    CartClient cartClient;

    public CartDTO addToCart(String userId, String productId) {
        return cartClient.addToCart(userId, productId);
    }
}

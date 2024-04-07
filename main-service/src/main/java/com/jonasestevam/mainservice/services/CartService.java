package com.jonasestevam.mainservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jonasestevam.domain.dtos.CartDTO;
import com.jonasestevam.domain.dtos.UserDTO;
import com.jonasestevam.mainservice.client.CartClient;

@Service
public class CartService {

    @Autowired
    CartClient cartClient;

    public CartDTO addToCart(String userId, String productId) {
        return cartClient.addToCart(userId, productId);
    }

    public void removeFromCart(String userID, String productiId) {
        cartClient.removeFromCart(userID, productiId);
    }

    public void deleteCart(UserDTO user) {
        CartDTO cart = getCartByUser(user.getId().toString());
        cartClient.deleteCart(cart.getId().toString());
    }

    public CartDTO getCartByUser(String userId) {
        return cartClient.getCartByUser(userId);
    }

    public CartDTO getById(String cartID) {
        return cartClient.getCartByID(cartID);
    }

}

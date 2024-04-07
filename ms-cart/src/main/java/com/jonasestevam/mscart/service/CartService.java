package com.jonasestevam.mscart.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.jonasestevam.domain.dtos.CartDTO;
import com.jonasestevam.domain.entities.Cart;
import com.jonasestevam.mscart.mapper.CartMapper;
import com.jonasestevam.mscart.repository.CartRepository;
import com.jonasestevam.mscart.repository.ProductRepository;
import com.jonasestevam.mscart.repository.UserRepository;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CartMapper cartMapper;

    public CartDTO addProdToCart(String userId, String productId) throws NotFoundException {
        var user = userRepository.findById(UUID.fromString(userId)).orElseThrow(() -> new NotFoundException());
        var product = productRepository.findById(UUID.fromString(productId)).orElseThrow(() -> new NotFoundException());
        try {
            var cart = cartRepository.findByUser(user).orElseThrow(() -> new NotFoundException());
            cart.getProducts().add(product);
            return cartMapper.toDto(cartRepository.save(cart));
        } catch (NotFoundException e) {
            Cart newCart = new Cart();
            newCart.getProducts().add(product);
            newCart.setUser(user);
            return cartMapper.toDto(cartRepository.save(newCart));
        }

    }

    public void removeFromCart(String userID, String productiId) throws NotFoundException {
        var cart = getCartByUser(userID);
        cart.getProducts().removeIf(p -> p.getId().equals(UUID.fromString(productiId)));
        cartRepository.save(cart);
    }

    public void deleteCart(String userId) throws NotFoundException {
        Cart cart = getCartByUser(userId);
        cartRepository.delete(cart);
    }

    public Cart getCartByUser(String userId) throws NotFoundException {
        var user = userRepository.findById(UUID.fromString(userId)).orElseThrow(() -> new NotFoundException());
        return cartRepository.findByUser(user).orElseThrow(() -> new NotFoundException());
    }

    public CartDTO getById(String cartID) throws NotFoundException {
        return cartMapper
                .toDto(cartRepository.findById(UUID.fromString(cartID)).orElseThrow(() -> new NotFoundException()));
    }
}

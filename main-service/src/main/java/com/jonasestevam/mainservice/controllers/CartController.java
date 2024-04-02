package com.jonasestevam.mainservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jonasestevam.domain.dtos.CartDTO;
import com.jonasestevam.domain.dtos.StoreDTO;
import com.jonasestevam.mainservice.security.AuthenticationService;
import com.jonasestevam.mainservice.services.CartService;

@RestController
@RequestMapping("cart")
public class CartController {

    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    CartService cartService;

    @PostMapping("{productId}")
    public ResponseEntity<CartDTO> addToCart(@RequestBody StoreDTO newStore,
            @RequestHeader(value = "Authorization", required = true) String authorizationHeader,
            @PathVariable("productId") String productId) {
        String token = authorizationHeader.substring(7);

        var user = authenticationService.getLoggedUserByToken(token);

        return ResponseEntity.ok(cartService.addToCart(user.getId().toString(), productId));

    }

}

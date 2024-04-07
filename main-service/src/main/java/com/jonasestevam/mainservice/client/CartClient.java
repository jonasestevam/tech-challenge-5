package com.jonasestevam.mainservice.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.jonasestevam.domain.dtos.CartDTO;

@Component
public class CartClient {

    @Autowired
    private RestTemplate restTemplate;

    private final String BASE_URL_CART_MNGMT = "http://localhost:8082/cart";

    public CartDTO addToCart(String userId, String productId) {
        String url = BASE_URL_CART_MNGMT + "/" + productId + "/" + userId;
        ResponseEntity<? extends Object> response = callPostApi(url, null, new CartDTO());

        var cartDTO = (CartDTO) response.getBody();
        return cartDTO;
    }

    public void removeFromCart(String userId, String productId) {
        String url = BASE_URL_CART_MNGMT + "/" + productId + "/" + userId;
        callDeleteApi(url);
    }

    public void deleteCart(String cartId) {
        String url = BASE_URL_CART_MNGMT + "/" + cartId;
        callDeleteApi(url);
    }

    public CartDTO getCartByUser(String userId) {
        String url = BASE_URL_CART_MNGMT + "/user/" + userId;
        return callGetApi(url).getBody();
    }

    public CartDTO getCartByID(String cartId) {
        String url = BASE_URL_CART_MNGMT + "/" + cartId;
        var response = callGetApi(url);

        return response.getBody();

    }

    @SuppressWarnings("null")
    private ResponseEntity<? extends Object> callPostApi(String url, Object request, Object obj) {
        return restTemplate.postForEntity(url, request, obj.getClass());
    }

    private void callDeleteApi(String url) {
        restTemplate.delete(url);
    }

    private ResponseEntity<CartDTO> callGetApi(String url) {
        return restTemplate.getForEntity(url, CartDTO.class);
    }

}

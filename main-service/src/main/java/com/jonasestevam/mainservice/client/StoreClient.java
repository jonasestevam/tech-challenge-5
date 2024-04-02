package com.jonasestevam.mainservice.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.jonasestevam.domain.dtos.ProductDTO;
import com.jonasestevam.domain.dtos.StoreDTO;

@Component
public class StoreClient {

    @Autowired
    private RestTemplate restTemplate;

    private final String BASE_URL_STORE_MNGMT = "http://localhost:8081/store";

    public StoreDTO save(StoreDTO newStore) {
        ResponseEntity<? extends Object> response = callPostApi(BASE_URL_STORE_MNGMT, newStore, new StoreDTO());

        var storeDTO = (StoreDTO) response.getBody();
        return storeDTO;
    }

    public ProductDTO addProductToStore(ProductDTO newProduct, String storeId) {
        String path = BASE_URL_STORE_MNGMT + "/" + "product" + "/" + storeId;
        ResponseEntity<? extends Object> response = callPostApi(path, newProduct,
                new ProductDTO());
        var product = (ProductDTO) response.getBody();

        return product;

    }

    @SuppressWarnings("null")
    private ResponseEntity<? extends Object> callPostApi(String url, Object request, Object obj) {
        return restTemplate.postForEntity(url, request, obj.getClass());
    }

}

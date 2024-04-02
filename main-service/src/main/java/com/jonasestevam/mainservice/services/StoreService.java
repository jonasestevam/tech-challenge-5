package com.jonasestevam.mainservice.services;

import javax.naming.NameNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jonasestevam.domain.dtos.ProductDTO;
import com.jonasestevam.domain.dtos.StoreDTO;
import com.jonasestevam.domain.dtos.UserDTO;
import com.jonasestevam.domain.interfaces.StoreServiceInterface;
import com.jonasestevam.mainservice.client.StoreClient;

@Service
public class StoreService implements StoreServiceInterface {

    @Autowired
    private StoreClient storeCliente;

    @Autowired
    UserService userService;

    @Override
    public StoreDTO save(StoreDTO newStore) {
        return storeCliente.save(newStore);
    }

    @Override
    public ProductDTO addProduct(ProductDTO newProductDTO, String storeID) {
        return storeCliente.addProductToStore(newProductDTO, storeID);
    }

    public void addOwnerToStore(UserDTO loggedUser, StoreDTO store) throws NameNotFoundException {
        userService.linkToStore(loggedUser.getId().toString(), store);
    }

}

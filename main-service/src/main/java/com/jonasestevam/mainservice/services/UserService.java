package com.jonasestevam.mainservice.services;

import java.time.LocalDate;
import java.util.UUID;

import javax.naming.NameNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jonasestevam.domain.dtos.StoreDTO;
import com.jonasestevam.domain.dtos.UserDTO;
import com.jonasestevam.mainservice.mappers.StoreMapper;
import com.jonasestevam.mainservice.mappers.UserMapper;
import com.jonasestevam.mainservice.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository repository;

    @Autowired
    UserMapper mapper;
    @Autowired
    StoreMapper storeMapper;

    public UserDTO save(UserDTO newUser) {

        newUser.setRegistrationDate(LocalDate.now());
        return mapper.toDto(repository.save(mapper.toEntity(newUser)));

    }

    public UserDTO findByUsername(String username) {
        var user = repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found!"));

        return mapper.toDto(user);
    }

    public void linkToStore(String userId, StoreDTO store) throws NameNotFoundException {
        var user = repository.findById(UUID.fromString(userId))
                .orElseThrow(() -> new NameNotFoundException("User not Found!"));

        user.setStore(storeMapper.toEntity(store));

        repository.save(user);
    }

}

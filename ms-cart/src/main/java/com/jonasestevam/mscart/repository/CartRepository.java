package com.jonasestevam.mscart.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jonasestevam.domain.entities.Cart;
import com.jonasestevam.domain.entities.User;

@Repository
public interface CartRepository extends JpaRepository<Cart, UUID> {

    public Optional<Cart> findByUser(User usuario);

}

package com.jonasestevam.mscart.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jonasestevam.domain.entities.Product;

public interface ProductRepository extends JpaRepository<Product, UUID> {

}

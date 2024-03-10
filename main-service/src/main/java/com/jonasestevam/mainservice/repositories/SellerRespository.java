package com.jonasestevam.mainservice.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jonasestevam.domain.entities.Seller;

public interface SellerRespository extends JpaRepository<Seller, UUID> {

}

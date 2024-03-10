package com.jonasestevam.mainservice.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jonasestevam.domain.entities.Buyer;

public interface BuyerRespository extends JpaRepository<Buyer, UUID> {

}

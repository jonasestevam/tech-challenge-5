package com.jonasestevam.mainservice.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jonasestevam.domain.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, UUID> {

}

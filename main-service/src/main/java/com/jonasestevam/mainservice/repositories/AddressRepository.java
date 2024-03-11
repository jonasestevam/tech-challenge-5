package com.jonasestevam.mainservice.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jonasestevam.domain.entities.Address;

public interface AddressRepository extends JpaRepository<Address, UUID> {

}

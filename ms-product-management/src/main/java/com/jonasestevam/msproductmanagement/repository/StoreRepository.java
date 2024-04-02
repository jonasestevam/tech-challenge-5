package com.jonasestevam.msproductmanagement.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jonasestevam.domain.entities.Store;

public interface StoreRepository extends JpaRepository<Store, UUID> {

}

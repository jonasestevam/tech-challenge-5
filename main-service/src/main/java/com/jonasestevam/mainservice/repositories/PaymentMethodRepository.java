package com.jonasestevam.mainservice.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jonasestevam.domain.entities.PaymentMethods;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethods, UUID> {

}

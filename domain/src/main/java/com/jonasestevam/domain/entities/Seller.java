package com.jonasestevam.domain.entities;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Table
@Entity
@Getter
@Setter
@AllArgsConstructor
public class Seller extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID storeID;
}

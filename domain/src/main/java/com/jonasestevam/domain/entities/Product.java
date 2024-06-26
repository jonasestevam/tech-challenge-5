package com.jonasestevam.domain.entities;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "product_id")
    private UUID id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String brand;

    @Column
    private BigDecimal price;

    @Column
    private Integer stockQuantity;

    @Column
    private String SKU;

    @ManyToOne()
    @JoinColumn(name = "store_id")
    private Store store;

    @ManyToMany(mappedBy = "products")
    private List<Cart> carts;
}

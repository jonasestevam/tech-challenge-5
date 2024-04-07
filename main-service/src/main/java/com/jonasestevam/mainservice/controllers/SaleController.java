package com.jonasestevam.mainservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jonasestevam.domain.dtos.SaleDTO;
import com.jonasestevam.mainservice.services.SaleService;

@RestController
@RequestMapping("sale")
public class SaleController {

    @Autowired
    SaleService saleService;

    @PostMapping
    public ResponseEntity<SaleDTO> save(@RequestBody SaleDTO saleDTO) {
        return ResponseEntity.ok(saleService.save(saleDTO));
    }

}

package com.jonasestevam.msproductmanagement.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EntityScan(basePackages = "com.jonasestevam.domain.entities")
public class ConfigJPA {

}

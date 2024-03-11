package com.jonasestevam.domain.dtos;

import java.time.LocalDate;
import java.util.UUID;

import lombok.Data;

@Data
public class UserDTO {
    private UUID id;
    private String username;
    private String email;
    private String password;
    private LocalDate registrationDate;
    private String taxPayerNumber;
}

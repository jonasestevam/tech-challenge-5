package com.jonasestevam.domain.dtos;

import lombok.Getter;
import lombok.Setter;

public class UserLoggedDTO extends UserDTO {
    @Setter
    @Getter
    private String token;
}

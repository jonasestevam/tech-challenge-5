package com.jonasestevam.mainservice.controllers.sec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jonasestevam.domain.dtos.UserDTO;
import com.jonasestevam.domain.dtos.UserLoggedDTO;
import com.jonasestevam.mainservice.security.AuthenticationService;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping()
    public ResponseEntity<UserLoggedDTO> authenticate(
            Authentication authentication) {
        return ResponseEntity.ok(authenticationService.authenticate(authentication));
    }

    @PostMapping("register")
    public ResponseEntity<UserLoggedDTO> createUser(@RequestBody UserDTO newUser) {
        return ResponseEntity.ok(authenticationService.register(newUser));
    }

}

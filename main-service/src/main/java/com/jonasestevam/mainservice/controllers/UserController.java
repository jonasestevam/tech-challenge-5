package com.jonasestevam.mainservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jonasestevam.mainservice.services.UserService;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    // @PostMapping
    // public ResponseEntity<UserDTO> createUser(UserDTO newUser) {
    //     return ResponseEntity.ok(userService.save(newUser));
    // }
}

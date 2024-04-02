package com.jonasestevam.mainservice.security;

import java.security.interfaces.RSAPublicKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.stereotype.Service;

import com.jonasestevam.domain.dtos.UserDTO;
import com.jonasestevam.domain.dtos.UserLoggedDTO;
import com.jonasestevam.mainservice.mappers.UserMapper;
import com.jonasestevam.mainservice.services.UserService;

@Service
public class AuthenticationService {

  @Value("${jwt.public.key}")
  private RSAPublicKey key;

  @Autowired
  private JwtService jwtService;

  @Autowired
  private UserService userService;

  @Autowired
  UserMapper userMapper;

  @Autowired
  PasswordEncoder passwordEncoder;

  public UserLoggedDTO authenticate(Authentication authentication) {
    String token = jwtService.generateToken(authentication);
    UserLoggedDTO user = userMapper.toLoggedUser(userService.findByUsername(authentication.getName()));
    user.setPassword(null);
    user.setToken(token);
    return user;
  }

  public UserLoggedDTO register(UserDTO newUser) {

    String encodedPass = passwordEncoder.encode(newUser.getPassword());
    newUser.setPassword(encodedPass);

    var savedUser = userService.save(newUser);
    Authentication auth = new UsernamePasswordAuthenticationToken(newUser.getUsername(), encodedPass);
    String token = jwtService.generateToken(auth);

    var loggedUser = userMapper.toLoggedUser(savedUser);

    loggedUser.setToken(token);

    loggedUser.setPassword(null);

    return loggedUser;
  }

  public UserDTO getLoggedUserByToken(String token) {
    var username = getUsernameByToken(token);
    return userService.findByUsername(username);
  }

  public String getUsernameByToken(String token) {
    JwtDecoder jwtDecoder = NimbusJwtDecoder.withPublicKey(this.key).build();
    var jwt = jwtDecoder.decode(token);
    return jwt.getSubject();
  }

}
